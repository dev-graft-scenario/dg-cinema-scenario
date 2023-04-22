package devgraft.dgcinema.service.query

import devgraft.dgcinema.domain.model.Auditorium
import devgraft.dgcinema.domain.ports.`in`.query.AuditoriumSearchUseCase
import devgraft.dgcinema.domain.ports.out.AuditoriumPort
import org.springframework.stereotype.Service

@Service
class AuditoriumSearchService(
    val auditoriumPort: AuditoriumPort
) : AuditoriumSearchUseCase {
    override fun getAuditoriumListByTheater(theaterId: Long): List<Auditorium> {
        return auditoriumPort.findAllByTheaterId(theaterId)
    }
}
