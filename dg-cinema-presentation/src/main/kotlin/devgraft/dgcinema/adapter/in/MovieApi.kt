package devgraft.dgcinema.adapter.`in`

import devgraft.dgcinema.domain.model.Movie
import devgraft.dgcinema.domain.ports.`in`.MovieSearchUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class MovieApi(private val movieSearchUseCase: MovieSearchUseCase) {

    @GetMapping("movies")
    fun searchMovieList(): MovieSearchListResponse {
        return toResponse(movieSearchUseCase.getMovieList())
    }

    @GetMapping("movies/{movieId}")
    fun searchMovie(@PathVariable(name = "movieId") movieId: Long): MovieSearchResponse {
        return toResponse(movieSearchUseCase.getMovie(movieId))
    }
}

private fun toResponse(movie: Movie): MovieSearchResponse {
    return MovieSearchResponse(
            movieId = movie.id,
            title = movie.title,
            description = movie.description,
            bannerUrl = movie.bannerUrl,
            genre = movie.genre,
            duration = movie.duration
    )
}
private fun toResponse(movies: List<Movie>): MovieSearchListResponse {
    val movieList = movies.stream()
            .map(::toResponse)
            .collect(Collectors.toUnmodifiableList())
    return MovieSearchListResponse(
            movies = movieList
    )
}
data class MovieSearchListResponse(val movies: List<MovieSearchResponse>)
data class MovieSearchResponse(
        val movieId: Long,
        val title: String,
        val description: String,
        val bannerUrl: String,
        val genre: String,
        val duration: Int
)
