package devgraft.cinema.booking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "BOOKING_ITEMS",
        indexes = {
                @Index(name = "IDX_BOOKING_ITEMS_BOOKING_ID", columnList = "booking_id"),
                @Index(name = "IDX_BOOKING_ITEMS_SCREENING_SEAT_ID", columnList = "screening_seat_id"),
        })
@Getter
class BookingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "screening_seat_id")
    private Long screeningSeatId;
}
