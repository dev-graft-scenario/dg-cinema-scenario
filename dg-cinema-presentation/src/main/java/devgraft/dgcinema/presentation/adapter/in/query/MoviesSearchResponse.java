package devgraft.dgcinema.presentation.adapter.in.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MoviesSearchResponse {
    private List<MovieSearchResponse> movies;

    public static MoviesSearchResponse mapped(final List<MovieSearchResponse> movies) {
        return new MoviesSearchResponse(movies);
    }
}
