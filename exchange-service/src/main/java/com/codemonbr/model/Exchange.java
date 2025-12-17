package com.codemonbr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "exchange")
public class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(name = "conversion_factor", nullable = false)
    private BigDecimal convertionFactor;

    @Transient
    private BigDecimal convertedValue;

    @Transient
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Exchange() {
    }

    public Exchange(Long id,
            String from,
            String to,
            BigDecimal convertionFactor,
            BigDecimal convertedValue,
            String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.convertionFactor = convertionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Exchange exchange = (Exchange) o;
        return Objects.equals(getId(), exchange.getId()) && Objects.equals(getFrom(), exchange.getFrom())
                && Objects.equals(getTo(), exchange.getTo())
                && Objects.equals(getConvertionFactor(), exchange.getConvertionFactor())
                && Objects.equals(getConvertedValue(), exchange.getConvertedValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getConvertionFactor(), getConvertedValue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConvertionFactor() {
        return convertionFactor;
    }

    public void setConvertionFactor(BigDecimal convertionFactor) {
        this.convertionFactor = convertionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }
}
