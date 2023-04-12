package devgraft.dgcinema.domain.ports.out

import devgraft.dgcinema.domain.model.Movie
import java.util.Optional

interface MoviePort {
    fun findById(movieId:Long) : Optional<Movie>
}