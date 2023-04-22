package devgraft.dgcinema.adapter.out

import devgraft.dgcinema.domain.model.Theater
import devgraft.dgcinema.domain.ports.out.TheaterPort
import org.springframework.stereotype.Component
import java.util.Optional

@Component
internal class TheaterAdapter(
    private val theaterRepository: TheaterRepository
) : TheaterPort {
    override fun findById(theaterId: Long): Optional<Theater> {
        return theaterRepository.findById(theaterId).map(::toTheater)
    }

    override fun findAll(): List<Theater> {
        return theaterRepository.findAll().stream()
            .map(::toTheater)
            .toList()
    }

    private fun toTheater(theaterEntity:TheaterEntity) : Theater {
        return Theater(
            id = theaterEntity.id!!,
            name = theaterEntity.name
        )
    }
}
