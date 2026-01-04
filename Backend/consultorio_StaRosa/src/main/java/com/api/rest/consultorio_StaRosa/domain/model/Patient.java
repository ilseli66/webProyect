package com.api.rest.consultorio_StaRosa.domain.model;

public class Patient {
    private final Long id;
    private final String name;
    private final String email;
    private final String allergies;
    private ClinicalHistory history;

    public Patient(Long id, String name, String email, String allergies) {
        this.id = id;
        this.name = name;
        this.email = email; 
        this.allergies = allergies;
    }

    public void updateHistory(String antecedents, String observations) {
        this.history = new ClinicalHistory(this.id, antecedents, observations);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAllergies() { return allergies; }
    public ClinicalHistory getHistory() { return history; }
}
