package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import com.api.rest.consultorio_StaRosa.domain.model.ClinicalHistory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_clinico")
public class ClinicalHistoryEntity {
    
    @Id
    private Long patientId;

    @Column(name = "antecedentes", columnDefinition = "TEXT")
    private String antecedentes;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId 
    @JoinColumn(name = "paciente_id")
    private PatientEntity paciente;

    protected ClinicalHistoryEntity() {}

    public static ClinicalHistoryEntity fromDomain(ClinicalHistory history, PatientEntity patientEntity) {
        ClinicalHistoryEntity entity = new ClinicalHistoryEntity();
        entity.patientId = patientEntity.getId();
        entity.antecedentes = history.getAntecedents();
        entity.observaciones = history.getObservations();
        entity.paciente = patientEntity;
        return entity;
    }

    public ClinicalHistory toDomain() {
        return new ClinicalHistory(
            this.patientId,
            this.antecedentes,
            this.observaciones
        );
    }

    public Long getPatientId() { return patientId; }
    public String getAntecedentes() { return antecedentes; }
    public String getObservaciones() { return observaciones; }
}
