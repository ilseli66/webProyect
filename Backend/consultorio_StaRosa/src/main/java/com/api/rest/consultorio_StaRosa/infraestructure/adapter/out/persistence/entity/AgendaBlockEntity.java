package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import java.time.LocalDateTime;

import com.api.rest.consultorio_StaRosa.domain.model.AgendaBlock;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bloqueo_agenda")
public class AgendaBlockEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "motivo")
    private String motivo;

    protected AgendaBlockEntity() {}

    public static AgendaBlockEntity fromDomain(AgendaBlock agendaBlock) {
        AgendaBlockEntity entity = new AgendaBlockEntity();
        entity.id = agendaBlock.getId();
        entity.fechaInicio = agendaBlock.getStart();
        entity.fechaFin = agendaBlock.getEnd();
        entity.motivo = agendaBlock.getReason();
        return entity;
    }

    public AgendaBlock toDomain() {
        return new AgendaBlock(
            this.id,
            this.fechaInicio,
            this.fechaFin,
            this.motivo
        );
    }

    // Getters
    public Long getId() { return id; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public String getMotivo() { return motivo; }
}
