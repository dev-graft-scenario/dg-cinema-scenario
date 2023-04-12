package devgraft.dgcinema.domain.ports.`in`

import devgraft.dgcinema.domain.model.Movie

interface MovieSearchUseCase {
    fun getMovie(movieId:Long) : Movie
    fun getMovieList() : List<Movie>
}
