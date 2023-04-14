package devgraft.dgcinema.adapter.`in`.query

import capture
import devgraft.dgcinema.RestDocsApiTest
import devgraft.dgcinema.domain.model.anMovie
import devgraft.dgcinema.domain.ports.`in`.query.MovieSearchUseCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MovieQueryApiTest : RestDocsApiTest() {
    @InjectMocks
    private lateinit var movieQueryApi: MovieQueryApi

    @Mock
    private lateinit var mockMovieSearchUseCase: MovieSearchUseCase

    @Captor
    private lateinit var movieIdCaptor: ArgumentCaptor<Long>
    override fun api() = arrayOf<Any>(movieQueryApi)

    @Test
    fun searchMovie_status_is_ok() {
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(anMovie().build())

        mockMvc.perform(get("/movies/{movieId}", 1))
            .andExpect(status().isOk)
    }

    @Test
    fun searchMovie_return_value() {
        val givenMovie = anMovie().title("givenTitle").description("givenDescription").build()
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(givenMovie)

        mockMvc.perform(get("/movies/{movieId}", 1))
                .andExpect(status().isOk)
            .andExpect(jsonPath("$.movieId").value(givenMovie.id))
            .andExpect(jsonPath("$.title").value(givenMovie.title))
            .andExpect(jsonPath("$.description").value(givenMovie.description))
            .andExpect(jsonPath("$.bannerUrl").value(givenMovie.bannerUrl))
            .andExpect(jsonPath("$.genre").value(givenMovie.genre))
            .andExpect(jsonPath("$.releaseDate").value(givenMovie.releaseDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
            .andExpect(jsonPath("$.duration").value(givenMovie.duration))
            .andDo(
                document(
                    pathParameters(
                        parameterWithName("movieId").description("영화 아이디")
                    ),
                    responseFields(
                        fieldWithPath("movieId").type(JsonFieldType.NUMBER).description("영화 아이디"),
                        fieldWithPath("title").type(JsonFieldType.STRING).description("영화 제목"),
                        fieldWithPath("description").type(JsonFieldType.STRING).description("영화 설명"),
                        fieldWithPath("bannerUrl").type(JsonFieldType.STRING).description("영화 배너 URL"),
                        fieldWithPath("genre").type(JsonFieldType.STRING).description("영화 장르"),
                        fieldWithPath("releaseDate").type(LocalDate::class).description("영화 개봉일"),
                        fieldWithPath("duration").type(JsonFieldType.NUMBER).description("영화 길이(1분)")
                    )
                )
            )
    }

    @Test
    fun searchMovie_passes_parameter_to_useCase() {
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(anMovie().build())

        mockMvc.perform(get("/movies/{movieId}", 1))

        verify(mockMovieSearchUseCase, times(1)).getMovie(capture(movieIdCaptor))
        Assertions.assertThat(movieIdCaptor.value).isEqualTo(1)
    }

    @Test
    fun searchMovieList_status_is_ok() {
        mockMvc.perform(get("/movies"))
            .andExpect(status().isOk)
    }

    @Test
    fun searchMovieList_return_value() {
        val givenMovie = anMovie().build()
        BDDMockito.given(mockMovieSearchUseCase.getMovieList()).willReturn(listOf(givenMovie))

        mockMvc.perform(get("/movies"))
            .andExpect(jsonPath("$.movies").isArray)
            .andExpect(jsonPath("$.movies[0].movieId").value(givenMovie.id))
            .andExpect(jsonPath("$.movies[0].title").value(givenMovie.title))
            .andExpect(jsonPath("$.movies[0].description").value(givenMovie.description))
            .andExpect(jsonPath("$.movies[0].bannerUrl").value(givenMovie.bannerUrl))
            .andExpect(jsonPath("$.movies[0].genre").value(givenMovie.genre))
            .andExpect(jsonPath("$.movies[0].duration").value(givenMovie.duration))
            .andExpect(
                jsonPath("$.movies[0].releaseDate").value(
                    givenMovie.releaseDate.format(
                        DateTimeFormatter.ofPattern(
                            "yyyy-MM-dd"
                        )
                    )
                )
            )
    }
}
