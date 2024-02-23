package devgraft.cinema.shard.domain.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class BaseRepository<AR extends AggregateRoot<AR, ARID>, ARID extends DomainId, R extends JpaRepository<AR, ARID>> implements Repository<AR, ARID> {
    protected final R repository;

    protected BaseRepository(final R repository) {
        this.repository = repository;
    }

    @Override
    public void add(final AR root) {
        this.repository.save(root);
    }

    @Override
    public Optional<AR> find(ARID id) {
        return repository.findById(id);
    }

    @Override
    public void remove(ARID id) {
        repository.deleteById(id);
    }

    @Override
    public void remove(AR root) {
        repository.delete(root);
    }
}
