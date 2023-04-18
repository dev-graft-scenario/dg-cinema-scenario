package devgraft.dgcinema.infrastructure.adapter.out;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "movie")
@Entity
@Getter
public class MovieEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "bannerUrl", nullable = false)
    private String bannerUrl;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "releaseDate", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "duration", nullable = false)
    private Integer duration;
}
