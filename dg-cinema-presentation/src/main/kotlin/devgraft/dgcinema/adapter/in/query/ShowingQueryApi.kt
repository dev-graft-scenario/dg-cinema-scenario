package devgraft.dgcinema.adapter.`in`.query

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

@RestController
class ShowingQueryApi {

    // 상영 목록 조회
    @GetMapping("movies/{movieId}/showings")
    private fun searchShowingList(
        @PathVariable(name = "movieId") movieId: Long,
        @RequestParam(name = "theaterId", required = false) theaterId: Long?,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @RequestParam(name = "date", required = false) showDate: LocalDate?
    ): ShowingSearchListResponse {
        return ShowingSearchListResponse(
            showings = listOf(
                ShowingItem(
                    1, 1, 1,
                    LocalDate.of(2023, 1, 1),
                    LocalTime.of(10, 0),
                    LocalTime.of(12, 0),
                    BigDecimal("1000.0"),
                    100, 51
                )
            )
        )
    }
}

private data class ShowingSearchListResponse(val showings: List<ShowingItem>)
private data class ShowingItem(
    val showingId: Long,
    val theaterId: Long,
    val movieId: Long,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val showDate: LocalDate,
    @JsonFormat(pattern = "hh:mm")
    val startTime: LocalTime,
    @JsonFormat(pattern = "hh:mm")
    val endTime: LocalTime,
    val price: BigDecimal,
    val seatTotalCount: Int,
    val seatRemainingCount: Int
)
