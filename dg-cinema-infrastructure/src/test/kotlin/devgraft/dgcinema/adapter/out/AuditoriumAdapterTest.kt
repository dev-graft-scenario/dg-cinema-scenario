package devgraft.dgcinema.adapter.out

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class AuditoriumAdapterTest {
    @InjectMocks
    private lateinit var auditoriumAdapter: AuditoriumAdapter

    @Test
    fun findAllByTheaterId_return_value() {

        val result = auditoriumAdapter.findAllByTheaterId(1)
        Assertions.assertThat(result).isNotEmpty
    }
}
