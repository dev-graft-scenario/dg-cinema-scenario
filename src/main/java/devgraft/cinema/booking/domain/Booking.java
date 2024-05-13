package devgraft.cinema.booking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "BOOKINGS",
        indexes = {
                @Index(name = "IDX_BOOKINGS_MEMBER_ID", columnList = "member_id"),
                @Index(name = "IDX_BOOKINGS_STATUS", columnList = "status")
        }
)
@Getter
public class Booking {
    public enum BookingStatus { RESERVED, PAID, CANCELLED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="booking_id")
    private List<BookingItem> bookingItems = new ArrayList<>();
    private BookingStatus status;
    private LocalDateTime reservedAt;

    /**
     * 예약 시작
     * screeningSeatIds 를 넘겨받음.
     * 4개 이하 인지 검사
     * screeningSeats 조회
     * 예매 가능한 상태인지 검사
     * 예매 정보 생성 (예매 정보 생성 이벤트 등록)
     * 예약 성공
     */

    /**
     * 결제 요청
     * bookingId 기준으로 조회
     * bookingItems 의 screening 정보 조회
     * price 계산
     *
     * 결제 요청 정보 + 금액 -> 결제 요청 (PG사 요청)
     * 결과 (성공여부, 트랜잭션아이디)
     * 결제 정보 추가?
     * 결제 실패 여부도 남겨야하는게 맞으니 payment 를 만들고
     */
    // ScreeningSeatId를 넘겨받음.
    //
}
