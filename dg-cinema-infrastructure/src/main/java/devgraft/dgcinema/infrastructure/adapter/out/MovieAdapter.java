package devgraft.dgcinema.infrastructure.adapter.out;

import devgraft.dgcinema.domain.model.Movie;
import devgraft.dgcinema.domain.port.out.MoviePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
class MovieAdapter implements MoviePort {
    private final MovieRepository movieRepository;

    @Override
    public Optional<Movie> findById(final Long movieId) {
        return movieRepository.findById(movieId).map(this::toMovie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll().stream()
                .map(this::toMovie).toList();
    }

    private Movie toMovie(final MovieEntity movieEntity) {
        return new Movie(movieEntity.getId(),
                movieEntity.getTitle(),
                movieEntity.getDescription(),
                movieEntity.getBannerUrl(),
                movieEntity.getGenre(),
                movieEntity.getReleaseDate(),
                movieEntity.getDuration());
    }
}
