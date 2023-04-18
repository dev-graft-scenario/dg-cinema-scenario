package devgraft.dgcinema.domain.ports.out

import devgraft.dgcinema.domain.model.Auditorium

interface AuditoriumPort {
    fun findAllByTheaterId(theaterId:Long): List<Auditorium>
}
