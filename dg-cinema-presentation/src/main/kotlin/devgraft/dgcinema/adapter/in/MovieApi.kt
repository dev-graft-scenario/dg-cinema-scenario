package devgraft.dgcinema.adapter.`in`

import devgraft.dgcinema.domain.Movie
import devgraft.dgcinema.port.`in`.MovieSearchUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieApi(private val movieSearchUseCase: MovieSearchUseCase) {
    @GetMapping("movies/{movieId}")
    fun searchMovie(@PathVariable(name = "movieId") movieId: Long) : Movie {
        return movieSearchUseCase.getMovie(movieId)
    }
}
