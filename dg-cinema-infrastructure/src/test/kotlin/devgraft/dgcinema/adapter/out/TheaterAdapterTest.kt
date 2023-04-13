package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.adapter.out.fixtures.anTheaterEntity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.util.Optional

@ExtendWith(MockitoExtension::class)
class TheaterAdapterTest {
    @InjectMocks
    private lateinit var theaterAdapter: TheaterAdapter

    @Mock
    private lateinit var mockTheaterRepository: TheaterRepository

    @Test
    fun findById_return_value_empty_case() {
        BDDMockito.given(mockTheaterRepository.findById(anyLong())).willReturn(Optional.empty())

        val result = theaterAdapter.findById(1L)

        Assertions.assertThat(result.isEmpty).isTrue()
    }

    @Test
    fun findById_return_value_present_case() {
        val givenTheaterId = 100L
        val givenTheaterEntity = anTheaterEntity().id(givenTheaterId).build()
        BDDMockito.given(mockTheaterRepository.findById(givenTheaterId)).willReturn(Optional.of(givenTheaterEntity))

        val resultOpt = theaterAdapter.findById(givenTheaterId)

        Assertions.assertThat(resultOpt.isPresent).isTrue()
        val result = resultOpt.get()
        Assertions.assertThat(result.id).isEqualTo(givenTheaterEntity.id)
        Assertions.assertThat(result.name).isEqualTo(givenTheaterEntity.name)
    }

    @Test
    fun findAll_return_value() {
        val givenTheaterEntityList = listOf(anTheaterEntity().build())
        BDDMockito.given(mockTheaterRepository.findAll()).willReturn(givenTheaterEntityList)

        val result = theaterAdapter.findAll()

        Assertions.assertThat(result).isNotEmpty
        for ((index, theater) in result.withIndex()) {
            Assertions.assertThat(theater.id).isEqualTo(givenTheaterEntityList[index].id)
            Assertions.assertThat(theater.name).isEqualTo(givenTheaterEntityList[index].name)
        }
    }
}
