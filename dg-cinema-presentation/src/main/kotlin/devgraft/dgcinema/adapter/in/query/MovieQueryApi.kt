package devgraft.dgcinema.adapter.`in`.query

import com.fasterxml.jackson.annotation.JsonFormat
import devgraft.dgcinema.domain.model.Movie
import devgraft.dgcinema.domain.ports.`in`.query.MovieSearchUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class MovieQueryApi(private val movieSearchUseCase: MovieSearchUseCase) {

    @GetMapping("movies")
    private fun searchMovieList(): MovieSearchListResponse {
        return toResponse(movieSearchUseCase.getMovieList())
    }

    @GetMapping("movies/{movieId}")
    private fun searchMovie(@PathVariable(name = "movieId") movieId: Long): MovieSearchResponse {
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
            releaseDate = movie.releaseDate,
            duration = movie.duration
    )
}
private fun toResponse(movies: List<Movie>): MovieSearchListResponse {
    val movieList = movies.stream()
            .map(::toResponse)
            .toList()
    return MovieSearchListResponse(
            movies = movieList
    )
}
private data class MovieSearchListResponse(val movies: List<MovieSearchResponse>)
private data class MovieSearchResponse(
    val movieId: Long,
    val title: String,
    val description: String,
    val bannerUrl: String,
    val genre: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val releaseDate: LocalDate,
    val duration: Int
)
