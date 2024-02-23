package devgraft.cinema.shard.domain.base;

import java.util.Arrays;

public abstract class ValueObject<T extends ValueObject<T>> implements DomainObject {
    @Override
    public int hashCode() {
        return Arrays.hashCode(getEqualityFields());
    }

    @Override
    public boolean equals(final Object obj) {
        if(null == obj) return false;
        if (!(obj.getClass().equals(getClass()))) return false;
        return equals((T) obj);
    }

    public boolean equals(final T other) {
        if (null == other) return false;
        return Arrays.equals(getEqualityFields(), other.getEqualityFields());
    }

    protected Object[] getEqualityFields() {
        return Arrays.stream(getClass().getDeclaredFields())
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).toArray();
    }
}
