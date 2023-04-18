package devgraft.dgcinema.domain.port.out;

import devgraft.dgcinema.domain.model.Movie;

import java.util.List;
import java.util.Optional;
public interface MoviePort {
    Optional<Movie> findById(Long movieId);
    List<Movie> findAll();
}
