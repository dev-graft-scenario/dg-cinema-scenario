package devgraft.dgcinema.domain.port.in;

import devgraft.dgcinema.domain.model.Movie;

import java.util.List;

public interface MovieSearchUseCase {
    Movie getMovie(Long movieId);
    List<Movie> getMovieList();
}
