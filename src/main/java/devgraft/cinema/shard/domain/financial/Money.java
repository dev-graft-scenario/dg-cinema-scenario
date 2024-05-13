package devgraft.cinema.shard.domain.financial;

import devgraft.cinema.shard.domain.base.ValueObject;

import java.math.BigDecimal;

public class Money extends ValueObject<Money> {
    public static final Money ZERO = wons(0L);
    private final BigDecimal amount;

    public Money(final BigDecimal amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(final Money money) {
        return new Money(this.amount.add(money.getAmount()));
    }

    public Money minus(final Money money) {
        return new Money(this.amount.subtract(money.getAmount()));
    }

    private BigDecimal getAmount() {
        return this.amount;
    }
}