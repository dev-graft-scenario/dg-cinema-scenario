package devgraft.dgcinema

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
class Showing(
    val id: Long,
    val movieId: Long,
    val theaterId: Long,
    val showDate: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val price: BigDecimal
)
