package com.api.rest.consultorio_StaRosa.domain.model;

import java.math.BigDecimal;

public class Procedure {
    private final Long id;
    private final String description;
    private final String name;
    private final BigDecimal basePrice;
    private final Integer durationMinutes;

    public Procedure(Long id, String description, String name, BigDecimal basePrice, Integer durationMinutes) {
        if (basePrice == null || basePrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.id = id;
        this.description = description;
        this.basePrice = basePrice;
        this.durationMinutes = durationMinutes;
        this.name = name;
    }
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public String getName() { return name; }
    public BigDecimal getBasePrice() { return basePrice; }
    public Integer getDurationMinutes() { return durationMinutes; }
}
