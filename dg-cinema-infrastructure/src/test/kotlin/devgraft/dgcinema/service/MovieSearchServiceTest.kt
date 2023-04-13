package devgraft.dgcinema.service

import devgraft.dgcinema.domain.model.anMovie
import devgraft.dgcinema.domain.ports.out.MoviePort
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
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
        Mockito.lenient().`when`(mockMovePort.findById(any())).thenReturn(Optional.of(anMovie().build()))
    }

    @Test
    fun getMovie_passes_param_to_moviePort() {

    }

    @Test
    fun getMovie_throw_not_found_movie_exception() {

    }

    @Test
    fun getMovie_return_value() {
        TODO("Not yet implemented")
    }
}
