package devgraft.dgcinema.infrastructure.adapter.out;


import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
interface MovieRepository extends Repository<MovieEntity, Long> {
    Optional<MovieEntity> findById(Long movieId);
    List<MovieEntity> findAll();
}
