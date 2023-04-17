package devgraft.dgcinema.domain.ports.`in`.query

import devgraft.dgcinema.domain.model.Auditorium

interface AuditoriumUseCase {
    fun getAuditoriumListByTheater(theaterId: Long): List<Auditorium>
}
