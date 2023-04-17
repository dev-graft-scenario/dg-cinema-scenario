package devgraft.dgcinema.reservation.api;

import devgraft.dgcinema.reservation.app.MovieSearchResponse;
import devgraft.dgcinema.reservation.app.MovieSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class MovieSearchApi {
    private final MovieSearchService movieSearchService;
    // 영화 조회
    @GetMapping("movies/{movieId}")
    MovieSearchResponse searchMovie(@PathVariable(name = "movieId") Long movieId) {
        return movieSearchService.searchMovie(movieId);
    }
}
