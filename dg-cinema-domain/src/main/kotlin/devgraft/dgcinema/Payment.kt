package devgraft.dgcinema

import java.math.BigDecimal
import java.time.LocalDateTime

enum class PaymentStatus {
    /** 결제 대기 **/
    PENDING,

    /** 결제 완료 **/
    COMPLETED,

    /** 결제 취소 **/
    CANCELED,

    /** 결제 실패 **/
    FAILED
}

class Payment(
    val paymentId: PaymentId,
    val status: PaymentStatus,
    val amount: BigDecimal,
    val paymentMethod: String,
    val createdAt: LocalDateTime,
    val paymentExpireAt: LocalDateTime,
    val completedAt: LocalDateTime
)
