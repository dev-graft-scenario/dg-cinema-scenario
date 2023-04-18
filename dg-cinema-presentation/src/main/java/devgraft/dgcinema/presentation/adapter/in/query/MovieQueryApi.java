package devgraft.dgcinema.presentation.adapter.in.query;

import devgraft.dgcinema.domain.port.in.MovieSearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class MovieQueryApi {
    private final MovieSearchUseCase movieSearchUseCase;

    @GetMapping("movies")
    MoviesSearchResponse searchMovies() {
        final List<MovieSearchResponse> movies = movieSearchUseCase.getMovieList().stream()
                .map(MovieSearchResponse::mapped)
                .toList();
        return MoviesSearchResponse.mapped(movies);
    }

    @GetMapping("movies/{movieId}")
    MovieSearchResponse searchMovie(@PathVariable(name = "movieId") Long movieId) {
        return MovieSearchResponse.mapped(movieSearchUseCase.getMovie(movieId));
    }
}
