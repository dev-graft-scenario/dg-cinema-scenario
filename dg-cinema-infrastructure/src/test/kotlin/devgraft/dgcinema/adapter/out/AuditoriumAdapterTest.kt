package devgraft.dgcinema.adapter.out

import capture
import devgraft.dgcinema.adapter.out.fixtures.anAuditoriumEntity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class AuditoriumAdapterTest {
    @InjectMocks
    private lateinit var auditoriumAdapter: AuditoriumAdapter
    @Mock
    private lateinit var mockAuditoriumRepository: AuditoriumRepository
    @Captor
    private lateinit var theaterIdCaptor: ArgumentCaptor<Long>

    @Test
    fun findAllByTheaterId_return_value() {
        val givenAuditoriumEntityList = listOf(anAuditoriumEntity().build())
        BDDMockito.given(mockAuditoriumRepository.findAllByTheaterId(anyLong())).willReturn(givenAuditoriumEntityList)
        val result = auditoriumAdapter.findAllByTheaterId(1)

        Assertions.assertThat(result).isNotEmpty
        for ((index, auditorium) in result.withIndex()) {
            Assertions.assertThat(auditorium.id).isEqualTo(givenAuditoriumEntityList[index].id)
            Assertions.assertThat(auditorium.theaterId).isEqualTo(givenAuditoriumEntityList[index].theaterId)
            Assertions.assertThat(auditorium.name).isEqualTo(givenAuditoriumEntityList[index].name)
        }
    }

    @Test
    fun findAllByTheaterId_passes_theaterId_to_repository() {
        val givenTheaterId = 1L

        auditoriumAdapter.findAllByTheaterId(givenTheaterId)

        verify(mockAuditoriumRepository, times(1)).findAllByTheaterId(capture(theaterIdCaptor))
        Assertions.assertThat(theaterIdCaptor.value).isEqualTo(givenTheaterId)
    }
}
