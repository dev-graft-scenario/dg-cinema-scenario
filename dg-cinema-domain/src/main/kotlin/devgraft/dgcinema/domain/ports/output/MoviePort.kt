package devgraft.dgcinema.domain.ports.output

import devgraft.dgcinema.domain.model.Movie
import java.util.*

interface MoviePort {
    fun findById(movieId:Long) : Optional<Movie>
}