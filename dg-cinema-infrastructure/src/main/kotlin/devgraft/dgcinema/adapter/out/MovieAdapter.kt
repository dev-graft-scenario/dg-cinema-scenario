package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.domain.model.Movie
import devgraft.dgcinema.domain.ports.out.MoviePort
import org.springframework.stereotype.Component
import java.util.Optional

@Component
internal class MovieAdapter(private val movieRepository: MovieRepository) : MoviePort {
    override fun findById(movieId: Long): Optional<Movie> {
        return movieRepository.findById(movieId).map { movieEntity ->
            Movie(
                id = movieEntity.id!!,
                title = movieEntity.title,
                description = movieEntity.description,
                bannerUrl = movieEntity.bannerUrl,
                genre = movieEntity.genre,
                duration = movieEntity.duration
            )
        }
    }
}