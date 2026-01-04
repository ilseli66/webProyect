package com.api.rest.consultorio_StaRosa.domain.model;

public class ClinicalHistory {
    private final Long patientId;
    private final String antecedents;
    private final String observations;

    public ClinicalHistory(Long patientId, String antecedents, String observations) {
        this.patientId = patientId;
        this.antecedents = antecedents;
        this.observations = observations;
    }

    public Long getPatientId() { return patientId; }
    public String getAntecedents() { return antecedents; }
    public String getObservations() { return observations; }
}
