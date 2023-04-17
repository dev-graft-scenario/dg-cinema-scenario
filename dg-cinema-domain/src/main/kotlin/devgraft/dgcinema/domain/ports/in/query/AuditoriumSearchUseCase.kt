package devgraft.dgcinema.domain.ports.`in`.query

import devgraft.dgcinema.domain.model.Auditorium

interface AuditoriumSearchUseCase {
    fun getAuditoriumListByTheater(theaterId: Long): List<Auditorium>
}
