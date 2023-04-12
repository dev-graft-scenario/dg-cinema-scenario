package devgraft.dgcinema.port.`in`

import devgraft.dgcinema.domain.Movie

interface MovieSearchUseCase {
    fun getMovie(movieId:Long) : Movie
    fun getMovieList() : List<Movie>
}
