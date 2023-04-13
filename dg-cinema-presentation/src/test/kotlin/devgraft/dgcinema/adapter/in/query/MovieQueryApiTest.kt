package devgraft.dgcinema.adapter.`in`.query

import capture
import devgraft.dgcinema.domain.model.anMovie
import devgraft.dgcinema.domain.ports.`in`.query.MovieSearchUseCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class MovieQueryApiTest {
    private lateinit var mockMvc:MockMvc
    @InjectMocks
    private lateinit var movieQueryApi: MovieQueryApi
    @Mock
    private lateinit var mockMovieSearchUseCase: MovieSearchUseCase
    @Captor
    private lateinit var movieIdCaptor: ArgumentCaptor<Long>
    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(movieQueryApi).build()
        Mockito.lenient().`when`(mockMovieSearchUseCase.getMovie(anyLong())).thenReturn(anMovie().build())
    }

    @Test
    fun searchMovie_status_is_ok() {
        mockMvc.perform(get("/movies/{movieId}", 1))
                .andExpect(status().isOk)
    }

    @Test
    fun searchMovie_return_value() {
        val givenMovie = anMovie().title("givenTitle").description("givenDescription").build()
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(givenMovie)

        mockMvc.perform(get("/movies/{movieId}", 1))
                .andExpect(jsonPath("$.movieId").value(givenMovie.id))
                .andExpect(jsonPath("$.title").value(givenMovie.title))
                .andExpect(jsonPath("$.description").value(givenMovie.description))
                .andExpect(jsonPath("$.bannerUrl").value(givenMovie.bannerUrl))
                .andExpect(jsonPath("$.genre").value(givenMovie.genre))
                .andExpect(jsonPath("$.duration").value(givenMovie.duration))
    }

    @Test
    fun searchMovie_passes_parameter_to_useCase() {
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
    }
}
