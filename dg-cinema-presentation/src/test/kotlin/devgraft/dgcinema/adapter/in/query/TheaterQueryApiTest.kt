package devgraft.dgcinema.adapter.`in`.query

import capture
import devgraft.dgcinema.domain.model.anTheater
import devgraft.dgcinema.domain.ports.`in`.query.TheaterSearchUseCase
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
import org.mockito.Mockito.times
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class TheaterQueryApiTest {
    private lateinit var mockMvc: MockMvc

    @InjectMocks
    private lateinit var theaterQueryApi: TheaterQueryApi

    @Mock
    private lateinit var mockTheaterSearchUseCase: TheaterSearchUseCase

    @Captor
    private lateinit var theaterIdCaptor: ArgumentCaptor<Long>

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(theaterQueryApi).build()
        Mockito.lenient().`when`(mockTheaterSearchUseCase.getTheater(anyLong())).thenReturn(anTheater().build())
        Mockito.lenient().`when`(mockTheaterSearchUseCase.getTheaterList()).thenReturn(listOf(anTheater().build()))
    }

    @Test
    fun searchTheater_status_is_ok() {
        mockMvc.perform(get("/theaters/{theaterId}", 1))
            .andExpect(status().isOk)
    }

    @Test
    fun searchTheater_return_value() {
        val givenTheaterId = 10L
        val givenTheater = anTheater().id(givenTheaterId).name("TEST").build()
        BDDMockito.given(mockTheaterSearchUseCase.getTheater(givenTheaterId)).willReturn(givenTheater)

        mockMvc.perform(get("/theaters/{theaterId}", givenTheaterId))
            .andExpect(jsonPath("$.id").value(givenTheater.id))
            .andExpect(jsonPath("$.name").value(givenTheater.name))
    }

    @Test
    fun searchTheater_passes_theaterId_to_useCase() {
        val givenTheaterId = 1L
        mockMvc.perform(get("/theaters/{theaterId}", givenTheaterId))

        Mockito.verify(mockTheaterSearchUseCase, Mockito.times(1)).getTheater(capture(theaterIdCaptor))
        Assertions.assertThat(theaterIdCaptor.value).isEqualTo(givenTheaterId)
    }

    @Test
    fun searchTheaterList_status_is_ok() {
        mockMvc.perform(get("/theaters"))
            .andExpect(status().isOk)
    }

    @Test
    fun searchTheaterList_return_value() {
        val givenTheater = anTheater().id(100L).name("QWERTY").build()
        BDDMockito.given(mockTheaterSearchUseCase.getTheaterList()).willReturn(listOf(givenTheater))

        mockMvc.perform(get("/theaters"))
            .andExpect(jsonPath("$.theaters").isArray)
            .andExpect(jsonPath("$.theaters[0].id").value(givenTheater.id))
            .andExpect(jsonPath("$.theaters[0].name").value(givenTheater.name))
    }

    @Test
    fun searchTheaterList_was_call_useCase() {
        mockMvc.perform(get("/theaters"))

        Mockito.verify(mockTheaterSearchUseCase, times(1)).getTheaterList()
    }
}
