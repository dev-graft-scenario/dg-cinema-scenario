package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.adapter.out.fixtures.anMovieEntity
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
        Assertions.assertThat(result.id).isEqualTo(givenMovieEntity.id)
        Assertions.assertThat(result.title).isEqualTo(givenMovieEntity.title)
        Assertions.assertThat(result.description).isEqualTo(givenMovieEntity.description)
        Assertions.assertThat(result.bannerUrl).isEqualTo(givenMovieEntity.bannerUrl)
        Assertions.assertThat(result.genre).isEqualTo(givenMovieEntity.genre)
        Assertions.assertThat(result.duration).isEqualTo(givenMovieEntity.duration)
    }

    @Test
    fun findAll_return_value() {
        val givenMovieEntityList = listOf(anMovieEntity().build())
        Mockito.lenient().`when`(mockMovieRepository.findAll()).thenReturn(givenMovieEntityList)

        val result = movieAdapter.findAll()

        Assertions.assertThat(result).isNotEmpty
        for ((index, movie) in result.withIndex()) {
            Assertions.assertThat(movie.id).isEqualTo(givenMovieEntityList[index].id)
            Assertions.assertThat(movie.title).isEqualTo(givenMovieEntityList[index].title)
            Assertions.assertThat(movie.description).isEqualTo(givenMovieEntityList[index].description)
            Assertions.assertThat(movie.bannerUrl).isEqualTo(givenMovieEntityList[index].bannerUrl)
            Assertions.assertThat(movie.genre).isEqualTo(givenMovieEntityList[index].genre)
            Assertions.assertThat(movie.duration).isEqualTo(givenMovieEntityList[index].duration)
        }
    }
}
