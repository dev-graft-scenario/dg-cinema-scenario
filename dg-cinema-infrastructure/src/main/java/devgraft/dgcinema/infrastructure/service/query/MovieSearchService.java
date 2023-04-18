package devgraft.dgcinema.infrastructure.service.query;

import devgraft.dgcinema.domain.model.Movie;
import devgraft.dgcinema.domain.model.MovieNotFoundException;
import devgraft.dgcinema.domain.port.in.MovieSearchUseCase;
import devgraft.dgcinema.domain.port.out.MoviePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class MovieSearchService implements MovieSearchUseCase {
    private final MoviePort moviePort;

    @Override
    public Movie getMovie(final Long movieId) {
        return moviePort.findById(movieId)
                .orElseThrow(MovieNotFoundException::new);
    }

    @Override
    public List<Movie> getMovieList() {
        return moviePort.findAll();
    }
}
