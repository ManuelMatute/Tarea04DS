/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(double amount) {
        this.amount = BigDecimal.valueOf(amount);
        this.currency = Currency.getInstance("USD");
    }

    public Money(double amount, Currency currency) {
        this.amount = BigDecimal.valueOf(amount);
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    // Operaciones
    public Money add(Money other) {
        checkCurrency(other);
        return new Money(this.amount.add(other.amount).doubleValue(), this.currency);
    }

    public Money subtract(Money other) {
        checkCurrency(other);
        return new Money(this.amount.subtract(other.amount).doubleValue(), this.currency);
    }

    public Money multiply(double factor) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(factor)).doubleValue(), this.currency);
    }

    private void checkCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Different currencies not supported");
        }
    }

    @Override
    public String toString() {
        return amount + " " + currency.getCurrencyCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount.compareTo(money.amount) == 0 &&
               Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
