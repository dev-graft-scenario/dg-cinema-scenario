package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.domain.model.Movie
import devgraft.dgcinema.domain.ports.out.MoviePort
import org.springframework.stereotype.Component
import java.util.Optional
import java.util.stream.Collectors

@Component
internal class MovieAdapter(private val movieRepository: MovieRepository) : MoviePort {
    override fun findById(movieId: Long): Optional<Movie> {
        return movieRepository.findById(movieId).map(::toMovie)
    }

    override fun findAll(): List<Movie> {
        return movieRepository.findAll().stream()
                .map(::toMovie)
                .collect(Collectors.toUnmodifiableList())
    }

    private fun toMovie(movieEntity: MovieEntity): Movie {
        return Movie(
                id = movieEntity.id!!,
                title = movieEntity.title,
                description = movieEntity.description,
                bannerUrl = movieEntity.bannerUrl,
                genre = movieEntity.genre,
                releaseDate = movieEntity.releaseDate,
                duration = movieEntity.duration
        )
    }
}
