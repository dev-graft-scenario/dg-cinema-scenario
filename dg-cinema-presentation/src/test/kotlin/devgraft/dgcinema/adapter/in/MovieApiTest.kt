package devgraft.dgcinema.adapter.`in`

import capture
import devgraft.dgcinema.domain.model.anMovie
import devgraft.dgcinema.domain.ports.`in`.MovieSearchUseCase
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
class MovieApiTest {
    private lateinit var mockMvc:MockMvc
    @InjectMocks
    private lateinit var movieApi: MovieApi
    @Mock
    private lateinit var mockMovieSearchUseCase: MovieSearchUseCase
    @Captor
    private lateinit var movieIdCaptor: ArgumentCaptor<Long>
    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(movieApi).build()
        Mockito.lenient().`when`(mockMovieSearchUseCase.getMovie(anyLong())).thenReturn(anMovie().build())
    }

    @Test
    fun searchMovie_is_status_ok() {
        mockMvc.perform(get("/movies/{movieId}", 1))
                .andExpect(status().isOk)
    }

    @Test
    fun searchMovie_passes_parameter_to_useCase() {
        mockMvc.perform(get("/movies/{movieId}", 1))

        verify(mockMovieSearchUseCase, times(1)).getMovie(capture(movieIdCaptor))
        Assertions.assertThat(movieIdCaptor.value).isEqualTo(1)
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
}
