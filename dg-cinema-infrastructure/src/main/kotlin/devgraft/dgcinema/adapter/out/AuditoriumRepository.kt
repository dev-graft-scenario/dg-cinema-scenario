package devgraft.dgcinema.adapter.out

import org.springframework.data.repository.Repository

@org.springframework.stereotype.Repository
internal interface AuditoriumRepository : Repository<AuditoriumEntity, Long> {

}
