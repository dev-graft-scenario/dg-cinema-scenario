package devgraft.dgcinema.adapter.out

import org.springframework.data.repository.Repository
import java.util.Optional

@org.springframework.stereotype.Repository
internal interface TheaterRepository : Repository<TheaterEntity, Long> {
    fun findById(movieId:Long): Optional<TheaterEntity>
    fun findAll() : List<TheaterEntity>
}
