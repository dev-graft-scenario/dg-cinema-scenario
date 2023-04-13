package devgraft.dgcinema.service.query

import devgraft.dgcinema.domain.model.Theater
import devgraft.dgcinema.domain.ports.`in`.query.TheaterSearchUseCase
import devgraft.dgcinema.domain.ports.out.TheaterPort
import org.springframework.stereotype.Service

@Service
class TheaterSearchService(
    private val theaterPort: TheaterPort
) : TheaterSearchUseCase {
    override fun getTheater(theaterId: Long): Theater {
        return theaterPort.findById(theaterId)
            .orElseThrow { RuntimeException("Theater with id $theaterId not found") }
    }

    override fun getTheaterList(): List<Theater> {
        return theaterPort.findAll()
    }
}
