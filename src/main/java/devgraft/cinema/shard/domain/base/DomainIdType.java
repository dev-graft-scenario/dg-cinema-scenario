package devgraft.cinema.shard.domain.base;

import org.hibernate.usertype.UserType;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;

public abstract class DomainIdType<ID extends DomainId> implements UserType<ID> {
    private final Class<ID> idClass;
    private final int sqlType;

    protected DomainIdType(Class<ID> idClass, int sqlType) {
        Assert.notNull(idClass, "DomainIdType.idClass must not be null.");
        this.idClass = idClass;
        this.sqlType = sqlType;
    }

    @Override
    public int getSqlType() {
        return this.sqlType;
    }

    @Override
    public Class<ID> returnedClass() {
        return this.idClass;
    }

    @Override
    public boolean equals(final ID x, final ID y) {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(final ID x) {
        return x.hashCode();
    }

    @Override
    public ID deepCopy(final ID value) {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(final ID value) {
        return value;
    }

    @Override
    public ID assemble(final Serializable cached, final Object owner) {
        return idClass.cast(cached);
    }
}
