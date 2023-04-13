package devgraft.dgcinema.service

import capture
import devgraft.dgcinema.domain.model.anMovie
import devgraft.dgcinema.domain.ports.out.MoviePort
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.Optional

@ExtendWith(MockitoExtension::class)
class MovieSearchServiceTest {
    @InjectMocks
    private lateinit var movieSearchService: MovieSearchService

    @Mock
    private lateinit var mockMovePort: MoviePort

    @Captor
    private lateinit var movieIdCaptor: ArgumentCaptor<Long>

    @BeforeEach
    fun setUp() {
        Mockito.lenient().`when`(mockMovePort.findById(anyLong())).thenReturn(Optional.of(anMovie().build()))
    }

    @Test
    fun getMovie_passes_param_to_moviePort() {
        val givenMovieId = 1L

        movieSearchService.getMovie(givenMovieId)

        Mockito.verify(mockMovePort, Mockito.times(1)).findById(capture(movieIdCaptor))
        Assertions.assertThat(movieIdCaptor.value).isEqualTo(givenMovieId)
    }

    @Test
    fun getMovie_throw_not_found_movie_exception() {
        val givenMovieId = 1L
        BDDMockito.given(mockMovePort.findById(anyLong())).willReturn(Optional.empty())

        val exception = Assertions.catchThrowableOfType({
            movieSearchService.getMovie(givenMovieId)
        }, RuntimeException::class.java)

        Assertions.assertThat(exception).isNotNull()
        Assertions.assertThat(exception.message).isEqualTo("Movie with id $givenMovieId not found")
    }

    @Test
    fun getMovie_return_value() {
        val givenMovie = anMovie().build()
        BDDMockito.given(mockMovePort.findById(anyLong())).willReturn(Optional.of(givenMovie))

        val result = movieSearchService.getMovie(givenMovie.id)

        Assertions.assertThat(result).isEqualTo(givenMovie)
    }
}
