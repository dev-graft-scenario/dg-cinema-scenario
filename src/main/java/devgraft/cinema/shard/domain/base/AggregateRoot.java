package devgraft.cinema.shard.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@MappedSuperclass
public abstract class AggregateRoot<T extends DomainEntity<T, TID>, TID extends DomainId> extends DomainEntity<T, TID> {
    @Transient
    @JsonIgnore
    private final transient List<Object> domainEvents = new ArrayList<>();

    protected AggregateRoot() {
    }

    protected void registerEvent(T event) {
        Assert.notNull(event, "AggregateRoot event must not be null");
        this.domainEvents.add(event);
    }

    @AfterDomainEventPublication
    protected void clearDomainEvents() {
        this.domainEvents.clear();
    }

    @DomainEvents
    protected Collection<Object> domainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }
}
