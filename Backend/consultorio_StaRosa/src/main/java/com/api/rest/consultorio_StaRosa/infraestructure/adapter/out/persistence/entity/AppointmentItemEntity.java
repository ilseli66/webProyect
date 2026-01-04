package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import java.math.BigDecimal;

import com.api.rest.consultorio_StaRosa.domain.model.AppointmentItem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita_item")
public class AppointmentItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precio_momento", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioMomento;

    @Column(name = "descuento", precision = 10, scale = 2)
    private BigDecimal descuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id", nullable = false)
    private AppointmentEntity cita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedimiento_id", nullable = false)
    private ProcedureEntity procedimiento;

    protected AppointmentItemEntity() {}

    public static AppointmentItemEntity fromDomain(AppointmentItem item, AppointmentEntity citaEntity, ProcedureEntity procedimientoEntity) {
        AppointmentItemEntity entity = new AppointmentItemEntity();
        entity.precioMomento = item.getPriceAtTime();
        entity.descuento = item.getDiscount();
        entity.cita = citaEntity;
        entity.procedimiento = procedimientoEntity;
        return entity;
    }

    public AppointmentItem toDomain() {
        return new AppointmentItem(
            this.procedimiento.getId(),
            this.precioMomento,
            this.descuento
        );
    }

    // Getters
    public Long getId() { return id; }
    public BigDecimal getPrecioMomento() { return precioMomento; }
    public BigDecimal getDescuento() { return descuento; }
    public AppointmentEntity getCita() { return cita; }
    public ProcedureEntity getProcedimiento() { return procedimiento; }
}
