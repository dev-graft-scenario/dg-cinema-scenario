package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.adapter.out.fixtures.anMovieEntity
import devgraft.dgcinema.adapter.out.fixtures.assertThatMovie

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.Optional

@ExtendWith(MockitoExtension::class)
class MovieAdapterTest {
    @InjectMocks
    private lateinit var movieAdapter: MovieAdapter
    @Mock
    private lateinit var mockMovieRepository: MovieRepository

    @Test
    fun findById_return_value_empty_case() {
        BDDMockito.given(mockMovieRepository.findById(anyLong())).willReturn(Optional.empty())

        val resultOpt = movieAdapter.findById(1L)

        Assertions.assertThat(resultOpt.isEmpty).isTrue()
    }

    @Test
    fun findById_return_value_present_case() {
        val givenMovieId = 100L
        val givenMovieEntity = anMovieEntity().id(givenMovieId).build()
        BDDMockito.given(mockMovieRepository.findById(givenMovieId)).willReturn(Optional.of(givenMovieEntity))

        val resultOpt = movieAdapter.findById(givenMovieId)

        Assertions.assertThat(resultOpt.isEmpty).isFalse()
        val result = resultOpt.get()
        assertThatMovie(result, givenMovieEntity)
    }

    @Test
    fun findAll_return_value() {
        val givenMovieEntityList = listOf(anMovieEntity().build())
        Mockito.lenient().`when`(mockMovieRepository.findAll()).thenReturn(givenMovieEntityList)

        val result = movieAdapter.findAll()

        Assertions.assertThat(result).isNotEmpty
        for ((index, movie) in result.withIndex()) {
            assertThatMovie(movie, givenMovieEntityList[index])
        }
    }
}
