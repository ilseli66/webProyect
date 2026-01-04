package com.api.rest.consultorio_StaRosa.domain.model;

import java.math.BigDecimal;

public class AppointmentItem {
    private final Long procedureId;
    private final BigDecimal priceAtTime;
    private final BigDecimal discount;

    public AppointmentItem(Long procedureId, BigDecimal priceAtTime, BigDecimal discount) {
        this.procedureId = procedureId;
        this.priceAtTime = priceAtTime;
        this.discount = discount != null ? discount : BigDecimal.ZERO;
    }
    public BigDecimal getPriceAtTime() { return priceAtTime; }
    public BigDecimal getDiscount() { return discount; }
    public Long getProcedureId() { return procedureId; }
}
