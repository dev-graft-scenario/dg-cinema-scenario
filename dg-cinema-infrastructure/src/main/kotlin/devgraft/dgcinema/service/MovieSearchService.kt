package devgraft.dgcinema.service

import devgraft.dgcinema.domain.Movie
import devgraft.dgcinema.port.`in`.MovieSearchUseCase
import devgraft.dgcinema.port.out.MoviePort
import org.springframework.stereotype.Service

@Service
internal class MovieSearchService(private val moviePort: MoviePort) : MovieSearchUseCase {
    override fun getMovie(movieId: Long): Movie {
        return moviePort.findById(movieId)
            .orElseThrow { RuntimeException("Movie with id $movieId not found") }
    }

    override fun getMovieList(): List<Movie> {
        TODO("Not yet implemented")
    }
}
