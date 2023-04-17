package devgraft.dgcinema.reservation.app;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieSearchResponse {
    private Long movieId;
    private String title;
    private String description;
    private String bannerUrl;
    private String genre;
    private Integer duration;
}
