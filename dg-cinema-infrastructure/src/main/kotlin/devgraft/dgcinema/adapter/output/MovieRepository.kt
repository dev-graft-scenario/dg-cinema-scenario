package devgraft.dgcinema.adapter.output

import org.springframework.data.repository.Repository
import java.util.*

@org.springframework.stereotype.Repository
internal interface MovieRepository : Repository<MovieEntity, Long> {
    fun findById(movieId:Long): Optional<MovieEntity>
}