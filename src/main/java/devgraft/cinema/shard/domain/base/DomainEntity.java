package devgraft.cinema.shard.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainEntity<T extends DomainEntity<T,TID>, TID extends DomainId> implements DomainObject {
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt;

    public abstract TID getId();

    public boolean equals(T other) {
        if (null == other) return false;
        if (null == getId()) return false;
        if (other.getClass().equals(getClass())) {
            return getId().equals(other.getId());
        }
        return super.equals(other);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        return equals((T) obj);
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }
}
