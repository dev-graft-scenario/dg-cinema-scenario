package devgraft.dgcinema.adapter.`in`.query

import devgraft.dgcinema.restdocs.RestDocsApiTest
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.restdocs.request.RequestDocumentation.requestParameters
import org.springframework.restdocs.snippet.Attributes
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ShowingQueryApiTest : RestDocsApiTest() {
    @InjectMocks
    private lateinit var showingQueryApi: ShowingQueryApi
    override fun api() = arrayOf<Any>(showingQueryApi)

    @Test
    fun searchShowingList_status_is_ok() {
        mockMvc.perform(get("/movies/{movieId}/showings", 1)
            .param("theaterId", "1")
            .param("showDate", "2023-01-01"))
            .andExpect(status().isOk)
    }

    @Test
    fun searchShowingList_return_value() {
        mockMvc.perform(
            RestDocumentationRequestBuilders.get("/movies/{movieId}/showings", 1)
            .param("theaterId", "1")
            .param("showDate", "2023-01-01"))
            .andExpect(jsonPath("$.showings").isArray)
            .andExpect(jsonPath("$.showings[0].showingId").value(1))
            .andExpect(jsonPath("$.showings[0].theaterId").value(1))
            .andExpect(jsonPath("$.showings[0].movieId").value(1))
            .andExpect(jsonPath("$.showings[0].showDate").value("2023-01-01"))
            .andExpect(jsonPath("$.showings[0].startTime").value("10:00"))
            .andExpect(jsonPath("$.showings[0].endTime").value("12:00"))
            .andExpect(jsonPath("$.showings[0].price").value("1000.0"))
            .andExpect(jsonPath("$.showings[0].seatTotalCount").value(100))
            .andExpect(jsonPath("$.showings[0].seatRemainingCount").value(51))
            .andDo(
                document(
                    pathParameters(
                        parameterWithName("movieId").description("영화 아이디")
                    ),
                    requestParameters(
                        parameterWithName("theaterId").description("상영관 아이디").optional(),
                        parameterWithName("showDate").description("상영 일자(기본값=now())").optional().attributes(Attributes.Attribute("format", "yyyy-MM-dd"))
                    ),
                    responseFields(
                        fieldWithPath("showings").type(JsonFieldType.ARRAY).description("영화 목록"),
                        fieldWithPath("showings[].showingId").type(JsonFieldType.NUMBER).description("상영 아이디"),
                        fieldWithPath("showings[].theaterId").type(JsonFieldType.NUMBER).description("상영관 아이디"),
                        fieldWithPath("showings[].movieId").type(JsonFieldType.NUMBER).description("영화 아이디"),
                        fieldWithPath("showings[].showDate").type(JsonFieldType.STRING).description("상영 일자").attributes(Attributes.Attribute("format", "yyyy-MM-dd")),
                        fieldWithPath("showings[].startTime").type(JsonFieldType.STRING).description("상영 시작 시간").attributes(Attributes.Attribute("format", "hh:mm")),
                        fieldWithPath("showings[].endTime").type(JsonFieldType.STRING).description("상영 종료 시간").attributes(Attributes.Attribute("format", "hh:mm")),
                        fieldWithPath("showings[].price").type(JsonFieldType.NUMBER).description("가격"),
                        fieldWithPath("showings[].seatTotalCount").type(JsonFieldType.NUMBER).description("전체 좌석 수"),
                        fieldWithPath("showings[].seatRemainingCount").type(JsonFieldType.NUMBER).description("남은 좌석 수")
                    )
                )
            )
    }
}
