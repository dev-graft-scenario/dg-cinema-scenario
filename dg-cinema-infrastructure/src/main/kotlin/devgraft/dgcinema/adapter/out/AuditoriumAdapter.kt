package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.domain.model.Auditorium
import devgraft.dgcinema.domain.ports.out.AuditoriumPort
import org.springframework.stereotype.Component

@Component
internal class AuditoriumAdapter(
        private val auditoriumRepository: AuditoriumRepository
) : AuditoriumPort {
    override fun findAllByTheaterId(theaterId: Long): List<Auditorium> {
        return auditoriumRepository.findAllByTheaterId(theaterId).stream()
                .map(::toAuditorium)
                .toList()
    }

    private fun toAuditorium(entity: AuditoriumEntity): Auditorium {
        return Auditorium(
                id = entity.id!!,
                theaterId = entity.theaterId,
                name = entity.name
        )
    }
}
