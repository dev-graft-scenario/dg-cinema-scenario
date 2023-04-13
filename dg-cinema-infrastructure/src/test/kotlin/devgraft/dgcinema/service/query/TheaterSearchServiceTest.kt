package devgraft.dgcinema.service.query

import capture
import devgraft.dgcinema.domain.model.anTheater
import devgraft.dgcinema.domain.ports.out.TheaterPort
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
class TheaterSearchServiceTest {
    @InjectMocks
    private lateinit var theaterSearchService: TheaterSearchService

    @Mock
    private lateinit var mockTheaterPort: TheaterPort

    @Captor
    private lateinit var theaterIdCaptor: ArgumentCaptor<Long>

    @BeforeEach
    fun setUp() {
        Mockito.lenient().`when`(mockTheaterPort.findById(anyLong())).thenReturn(Optional.of(anTheater().build()))
        Mockito.lenient().`when`(mockTheaterPort.findAll()).thenReturn(listOf(anTheater().build()))
    }

    @Test
    fun getTheater_passes_param_to_TheaterPort() {
        val givenTheaterId = 1L

        theaterSearchService.getTheater(givenTheaterId)

        Mockito.verify(mockTheaterPort, Mockito.times(1)).findById(capture(theaterIdCaptor))
        Assertions.assertThat(theaterIdCaptor.value).isEqualTo(givenTheaterId)
    }

    @Test
    fun getTheater_throw_not_found_theater_exception() {
        val givenTheaterId = 1L
        BDDMockito.given(mockTheaterPort.findById(anyLong())).willReturn(Optional.empty())

        val exception = Assertions.catchThrowableOfType({
            theaterSearchService.getTheater(givenTheaterId)
        }, RuntimeException::class.java)

        Assertions.assertThat(exception.message).isEqualTo("Theater with id $givenTheaterId not found")
    }

    @Test
    fun getTheater_return_value() {
        val givenTheater = anTheater().build()
        BDDMockito.given(mockTheaterPort.findById(anyLong())).willReturn(Optional.of(givenTheater))

        val result = theaterSearchService.getTheater(givenTheater.id)

        Assertions.assertThat(result.id).isEqualTo(givenTheater.id)
        Assertions.assertThat(result.name).isEqualTo(givenTheater.name)
    }

    @Test
    fun getTheaterList_return_value() {
        val givenTheaterList = listOf(anTheater().build())
        BDDMockito.given(mockTheaterPort.findAll()).willReturn(givenTheaterList)

        val result = theaterSearchService.getTheaterList()

        Assertions.assertThat(result).isNotEmpty()
        for((index, theater) in result.withIndex()) {
            Assertions.assertThat(theater).isEqualTo(givenTheaterList.get(index))
        }
    }
}
