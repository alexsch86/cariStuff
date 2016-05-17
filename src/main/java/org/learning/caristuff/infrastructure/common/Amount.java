package org.learning.caristuff.infrastructure.common;

import org.learning.caristuff.infrastructure.validation.Required;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static java.math.BigDecimal.ROUND_HALF_UP;

@Embeddable
public class Amount extends ValueObject {

    private static final DecimalFormat DECIMAL_FORMAT_EN = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(new Locale("en")));

    public static Amount zero() {
        return new Amount(0);
    }

    @Required
    @Column(nullable = false)
    private BigDecimal value;

    @SuppressWarnings("unused")
    private Amount() {
    }

    public Amount(String value) {
        this(Double.parseDouble(value.replaceAll(",", ".")));
    }

    public Amount(double value) {
        this.value = BigDecimal.valueOf(value).setScale(2, ROUND_HALF_UP);
    }

    private Amount(BigDecimal bigDecimal) {
        this(bigDecimal.doubleValue());
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount add(Amount amount) {
        return new Amount(this.value.add(amount.getValue()));
    }

    public Amount subtract(Amount amount) {
        return new Amount(this.value.subtract(amount.getValue()));
    }

    public boolean isSmallerThan(Amount other) {
        return value.compareTo(other.getValue()) < 0;
    }

    public boolean isBiggerThanOrEqualTo(Amount other) {
        return !this.isSmallerThan(other);
    }

    @Override
    public String toString() {
        return DECIMAL_FORMAT_EN.format(value.doubleValue());
    }

    @Override
    public final boolean equals(Object obj) {
        if(! (obj instanceof Amount)) {
            return false;
        }
        return this.value.toString().equals(((Amount) obj).value.toString());
    }

}
