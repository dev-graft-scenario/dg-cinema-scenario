package devgraft.cinema.shard.domain.base;

import java.util.Optional;

public interface Repository<AR extends AggregateRoot<AR, ARID>, ARID extends DomainId> {
    void add(AR root);
    Optional<AR> find(ARID id);
    void remove(ARID id);
    void remove(AR root);
}
