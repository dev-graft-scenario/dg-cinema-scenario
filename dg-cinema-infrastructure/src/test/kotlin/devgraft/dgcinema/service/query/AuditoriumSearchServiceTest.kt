package devgraft.dgcinema.service.query

import capture
import devgraft.dgcinema.domain.model.anAuditorium
import devgraft.dgcinema.domain.ports.out.AuditoriumPort
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
class AuditoriumSearchServiceTest {
    @InjectMocks
    private lateinit var auditoriumSearchService:AuditoriumSearchService
    @Mock
    private lateinit var mockAuditoriumPort: AuditoriumPort
    @Captor
    private lateinit var theaterIdCaptor: ArgumentCaptor<Long>
    @Test
    fun getAuditoriumListByTheater_return_value() {
        val givenAuditorium = anAuditorium().build()
        val givenAuditoriumList = listOf(givenAuditorium)
        BDDMockito.given(mockAuditoriumPort.findAllByTheaterId(anyLong())).willReturn(givenAuditoriumList)

        val result = auditoriumSearchService.getAuditoriumListByTheater(1L)

        Assertions.assertThat(result).isNotEmpty
        for ((index, auditorium) in result.withIndex()) {
            Assertions.assertThat(auditorium.id).isEqualTo(givenAuditoriumList[index].id)
            Assertions.assertThat(auditorium.theaterId).isEqualTo(givenAuditoriumList[index].theaterId)
            Assertions.assertThat(auditorium.name).isEqualTo(givenAuditoriumList[index].name)
        }
    }

    @Test
    fun getAuditoriumListByTheater_passes_theaterId_to_port() {
        val givenTheaterId = 1L

        auditoriumSearchService.getAuditoriumListByTheater(givenTheaterId)

        verify(mockAuditoriumPort, times(1)).findAllByTheaterId(capture(theaterIdCaptor))
    }
}
