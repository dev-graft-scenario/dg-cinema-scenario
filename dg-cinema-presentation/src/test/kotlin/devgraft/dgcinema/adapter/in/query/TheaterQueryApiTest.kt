package devgraft.dgcinema.adapter.`in`.query

import capture
import devgraft.dgcinema.domain.model.anAuditorium
import devgraft.dgcinema.domain.model.anTheater
import devgraft.dgcinema.domain.ports.`in`.query.AuditoriumSearchUseCase
import devgraft.dgcinema.domain.ports.`in`.query.TheaterSearchUseCase
import devgraft.dgcinema.restdocs.RestDocsApiTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class TheaterQueryApiTest : RestDocsApiTest() {
    @InjectMocks
    private lateinit var theaterQueryApi: TheaterQueryApi

    @Mock
    private lateinit var mockTheaterSearchUseCase: TheaterSearchUseCase

    @Mock
    private lateinit var mockAuditoriumSearchUseCase: AuditoriumSearchUseCase

    @Captor
    private lateinit var theaterIdCaptor: ArgumentCaptor<Long>

    override fun api() = arrayOf<Any>(theaterQueryApi)

    @Test
    fun searchTheater_status_is_ok() {
        BDDMockito.given(mockTheaterSearchUseCase.getTheater(anyLong())).willReturn(anTheater().build())

        mockMvc.perform(get("/theaters/{theaterId}", 1))
            .andExpect(status().isOk)
    }

    @Test
    fun searchTheater_return_value() {
        val givenTheaterId = 10L
        val givenTheater = anTheater().id(givenTheaterId).name("TEST").build()
        BDDMockito.given(mockTheaterSearchUseCase.getTheater(givenTheaterId)).willReturn(givenTheater)

        mockMvc.perform(RestDocumentationRequestBuilders.get("/theaters/{theaterId}", givenTheaterId))
            .andExpect(jsonPath("$.theaterId").value(givenTheater.id))
            .andExpect(jsonPath("$.theaterName").value(givenTheater.name))
            .andDo(
                document(
                    RequestDocumentation.pathParameters(
                        RequestDocumentation.parameterWithName("theaterId").description("상영관 아이디")
                    ),
                    responseFields(
                        fieldWithPath("theaterId").type(JsonFieldType.NUMBER).description("상영관 아이디"),
                        fieldWithPath("theaterName").type(JsonFieldType.STRING).description("상영관 이름"),
                    )
                )
            )
    }

    @Test
    fun searchTheater_passes_theaterId_to_useCase() {
        val givenTheaterId = 1L
        val givenTheater = anTheater().id(givenTheaterId).name("TEST").build()
        BDDMockito.given(mockTheaterSearchUseCase.getTheater(givenTheaterId)).willReturn(givenTheater)

        mockMvc.perform(get("/theaters/{theaterId}", givenTheaterId))

        verify(mockTheaterSearchUseCase, times(1)).getTheater(capture(theaterIdCaptor))
        Assertions.assertThat(theaterIdCaptor.value).isEqualTo(givenTheaterId)
    }

    @Test
    fun searchTheaterList_status_is_ok() {
        BDDMockito.given(mockTheaterSearchUseCase.getTheaterList()).willReturn(listOf(anTheater().build()))

        mockMvc.perform(get("/theaters"))
            .andExpect(status().isOk)
    }

    @Test
    fun searchTheaterList_return_value() {
        val givenTheater = anTheater().id(100L).name("QWERTY").build()
        BDDMockito.given(mockTheaterSearchUseCase.getTheaterList()).willReturn(listOf(givenTheater))

        mockMvc.perform(RestDocumentationRequestBuilders.get("/theaters"))
            .andExpect(jsonPath("$.theaters").isArray)
            .andExpect(jsonPath("$.theaters[0].theaterId").value(givenTheater.id))
            .andExpect(jsonPath("$.theaters[0].theaterName").value(givenTheater.name))
            .andDo(
                document(
                    responseFields(
                        fieldWithPath("theaters").type(JsonFieldType.ARRAY).description("상영관 목록"),
                        fieldWithPath("theaters[].theaterId").type(JsonFieldType.NUMBER).description("상영관 아이디"),
                        fieldWithPath("theaters[].theaterName").type(JsonFieldType.STRING).description("상영관 이름"),
                    )
                )
            )
    }

    @Test
    fun searchTheaterList_was_call_useCase() {
        val givenTheater = anTheater().id(100L).name("QWERTY").build()
        BDDMockito.given(mockTheaterSearchUseCase.getTheaterList()).willReturn(listOf(givenTheater))

        mockMvc.perform(get("/theaters"))

        verify(mockTheaterSearchUseCase, times(1)).getTheaterList()
    }

    @Test
    fun searchAuditoriumList_status_is_ok() {
        mockMvc.perform(get("/theaters/{theaterId}/auditoriums", 1))
                .andExpect(status().isOk)
    }

    @Test
    fun searchAuditoriumList_return_value() {
        val givenAuditorium = anAuditorium().build()
        BDDMockito.given(mockAuditoriumSearchUseCase.getAuditoriumListByTheater(anyLong()))
                .willReturn(listOf(givenAuditorium))

        mockMvc.perform(get("/theaters/{theaterId}/auditoriums", givenAuditorium.theaterId))
                .andExpect(jsonPath("$.auditoriums").isArray)
                .andExpect(jsonPath("$.auditoriums[0].auditoriumId").value(givenAuditorium.id))
                .andExpect(jsonPath("$.auditoriums[0].theaterId").value(givenAuditorium.theaterId))
                .andExpect(jsonPath("$.auditoriums[0].auditoriumName").value(givenAuditorium.name))
                .andDo(
                        document(
                                responseFields(
                                        fieldWithPath("auditoriums").type(JsonFieldType.ARRAY).description("상영실 목록"),
                                        fieldWithPath("auditoriums[].auditoriumId").type(JsonFieldType.NUMBER).description("상영실 아이디"),
                                        fieldWithPath("auditoriums[].theaterId").type(JsonFieldType.NUMBER).description("상영관 아이디"),
                                        fieldWithPath("auditoriums[].auditoriumName").type(JsonFieldType.STRING).description("상영실 이름"),
                                )
                        )
                )
    }

    @Test
    fun searchAuditoriumList_passes_theaterId_to_useCase() {
        val givenTheaterId = 1L

        mockMvc.perform(get("/theaters/{theaterId}/auditoriums", givenTheaterId))

        verify(mockAuditoriumSearchUseCase, times(1)).getAuditoriumListByTheater(capture(theaterIdCaptor))
        assertThat(theaterIdCaptor.value).isEqualTo(givenTheaterId)
    }
}
