package devgraft.dgcinema.domain.ports.`in`.query

import devgraft.dgcinema.domain.model.Theater

interface TheaterSearchUseCase {
    fun getTheater(theaterId:Long) : Theater
    fun getTheaterList() : List<Theater>
}
