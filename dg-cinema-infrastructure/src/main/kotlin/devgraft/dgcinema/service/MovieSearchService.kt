package devgraft.dgcinema.service

import devgraft.dgcinema.domain.model.Movie
import devgraft.dgcinema.domain.ports.`in`.MovieSearchUseCase
import devgraft.dgcinema.domain.ports.out.MoviePort
import org.springframework.stereotype.Service

@Service
internal class MovieSearchService(private val moviePort: MoviePort) : MovieSearchUseCase {
    override fun getMovie(movieId: Long): Movie {
        return moviePort.findById(movieId)
            .orElseThrow { RuntimeException("Movie with id $movieId not found") }
    }

    override fun getMovieList(): List<Movie> {
        return moviePort.findAll()
    }
}
