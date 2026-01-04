package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import java.time.LocalDate;

import com.api.rest.consultorio_StaRosa.domain.model.FollowUp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seguimiento")
public class FollowUpEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resumen", columnDefinition = "TEXT")
    private String resumen;

    @Column(name = "fecha_sugerida_proxima")
    private LocalDate fechaSugeridaProxima;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id", nullable = false, unique = true)
    private AppointmentEntity cita;

    protected FollowUpEntity() {}

    public static FollowUpEntity fromDomain(FollowUp followUp, AppointmentEntity citaEntity) {
        FollowUpEntity entity = new FollowUpEntity();
        entity.resumen = followUp.getSummary();
        entity.fechaSugeridaProxima = followUp.getNextSuggestedDate();
        entity.cita = citaEntity;
        return entity;
    }

    public FollowUp toDomain() {
        return new FollowUp(
            this.cita.getId(),
            this.resumen,
            this.fechaSugeridaProxima
        );
    }

    // Getters
    public Long getId() { return id; }
    public String getResumen() { return resumen; }
    public LocalDate getFechaSugeridaProxima() { return fechaSugeridaProxima; }
    public AppointmentEntity getCita() { return cita; }
}
