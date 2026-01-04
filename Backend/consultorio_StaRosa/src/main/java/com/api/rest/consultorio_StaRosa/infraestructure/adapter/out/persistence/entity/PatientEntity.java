package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import com.api.rest.consultorio_StaRosa.domain.model.Patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String alergias;

    private String email;

    protected PatientEntity() {}

    public static PatientEntity fromDomain(Patient patient) {
        PatientEntity entity = new PatientEntity();
        entity.id = patient.getId();
        entity.nombre = patient.getName();
        entity.email = patient.getEmail();
        entity.alergias = patient.getAllergies();
        return entity;
    }

    public Patient toDomain() {
        Patient patient = new Patient(this.id, this.nombre, this.email, this.alergias);
        return patient;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getAlergias() { return alergias; }
    public String getEmail() { return email; }
}
