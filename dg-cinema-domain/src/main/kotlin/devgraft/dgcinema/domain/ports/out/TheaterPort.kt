package devgraft.dgcinema.domain.ports.out

import devgraft.dgcinema.domain.model.Theater
import java.util.Optional

interface TheaterPort {
    fun findById(theaterId:Long) : Optional<Theater>
    fun findAll(): List<Theater>
}
