package devgraft.dgcinema.adapter.out

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class AuditoriumAdapterTest {
    @InjectMocks
    private lateinit var auditoriumAdapter: AuditoriumAdapter
    @Mock
    private lateinit var mockAuditoriumRepository: AuditoriumRepository


    @Test
    fun findAllByTheaterId_return_value() {

        val result = auditoriumAdapter.findAllByTheaterId(1)

        Assertions.assertThat(result).isNotEmpty
    }

    @Test
    fun findAllByTheaterId_passes_theaterId_to_repository() {
        val givenTheaterId = 1L

        auditoriumAdapter.findAllByTheaterId(givenTheaterId)

        verify(mockAuditoriumRepository, times(1)).findAll()
    }
}
