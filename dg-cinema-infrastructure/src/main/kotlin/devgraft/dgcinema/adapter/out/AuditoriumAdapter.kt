package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.domain.model.Auditorium
import devgraft.dgcinema.domain.ports.out.AuditoriumPort
import org.springframework.stereotype.Component

@Component
class AuditoriumAdapter : AuditoriumPort {
    override fun findAllByTheaterId(theaterId: Long): List<Auditorium> {
        return listOf(Auditorium(1, 1, ""))
    }
}
