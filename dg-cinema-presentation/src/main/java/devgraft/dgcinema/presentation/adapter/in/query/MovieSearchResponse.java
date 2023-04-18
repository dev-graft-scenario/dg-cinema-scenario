package devgraft.dgcinema.presentation.adapter.in.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import devgraft.dgcinema.domain.model.Movie;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MovieSearchResponse {
    private Long movieId;
    private String title;
    private String description;
    private String bannerUrl;
    private String genre;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Integer duration;

    public static MovieSearchResponse mapped(final Movie movie) {
        return new MovieSearchResponse(movie.id(),
                movie.title(),
                movie.description(),
                movie.bannerUrl(),
                movie.genre(),
                movie.releaseDate(),
                movie.duration());
    }
}
