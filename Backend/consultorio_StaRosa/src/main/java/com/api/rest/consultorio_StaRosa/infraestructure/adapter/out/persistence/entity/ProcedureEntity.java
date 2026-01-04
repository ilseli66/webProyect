package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import java.math.BigDecimal;

import com.api.rest.consultorio_StaRosa.domain.model.Procedure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "procedimiento")
public class ProcedureEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    protected ProcedureEntity() {}

    public static ProcedureEntity fromDomain(Procedure procedure) {
        ProcedureEntity entity = new ProcedureEntity();
        entity.id = procedure.getId();
        entity.nombre = procedure.getName();
        entity.descripcion = procedure.getDescription();
        entity.precioBase = procedure.getBasePrice();
        entity.duracionMinutos = procedure.getDurationMinutes();
        return entity;
    }

    public Procedure toDomain() {
        return new Procedure(
            this.id,
            this.descripcion,
            this.nombre,
            this.precioBase,
            this.duracionMinutos
        );
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getPrecioBase() { return precioBase; }
    public Integer getDuracionMinutos() { return duracionMinutos; }
}
