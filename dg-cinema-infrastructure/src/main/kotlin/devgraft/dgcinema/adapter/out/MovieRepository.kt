package devgraft.dgcinema.adapter.out

import org.springframework.data.repository.Repository
import java.util.Optional

@org.springframework.stereotype.Repository
internal interface MovieRepository : Repository<MovieEntity, Long> {
    fun findById(movieId:Long): Optional<MovieEntity>
}