package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import java.time.LocalTime;

import com.api.rest.consultorio_StaRosa.domain.model.AvailableSchedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_disponible")
public class AvailableScheduleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    protected AvailableScheduleEntity() {}

    public static AvailableScheduleEntity fromDomain(AvailableSchedule schedule) {
        AvailableScheduleEntity entity = new AvailableScheduleEntity();
        entity.id = schedule.getId();
        entity.diaSemana = schedule.getDayOfWeek();
        entity.horaInicio = schedule.getStart();
        entity.horaFin = schedule.getEnd();
        return entity;
    }

    public AvailableSchedule toDomain() {
        return new AvailableSchedule(
            this.id,
            this.diaSemana,
            this.horaInicio,
            this.horaFin
        );
    }

    // Getters
    public Long getId() { return id; }
    public Integer getDiaSemana() { return diaSemana; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
}
