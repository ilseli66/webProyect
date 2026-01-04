package com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.api.rest.consultorio_StaRosa.domain.enums.StatusAppoinment;
import com.api.rest.consultorio_StaRosa.domain.model.Appointment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita")
public class AppointmentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private StatusAppoinment estado;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private PatientEntity paciente;

    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentItemEntity> items = new ArrayList<>();

    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
    private FollowUpEntity seguimiento;

    protected AppointmentEntity() {}

    public static AppointmentEntity fromDomain(Appointment appointment, PatientEntity patientEntity) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.id = appointment.getId();
        entity.fecha = appointment.getDate();
        entity.horaInicio = appointment.getStartTime();
        entity.horaFin = appointment.getEndTime();
        entity.estado = appointment.getStatus();
        entity.observaciones = appointment.getObservations();
        entity.paciente = patientEntity;
        return entity;
    }

    public Appointment toDomain() {
        Appointment appointment = new Appointment(
            this.id,
            this.fecha,
            this.horaInicio,
            this.horaFin,
            this.paciente.toDomain()
        );
        return appointment;
    }

    // Getters para relaciones
    public Long getId() { return id; }
    public PatientEntity getPaciente() { return paciente; }
    public List<AppointmentItemEntity> getItems() { return items; }
    public FollowUpEntity getSeguimiento() { return seguimiento; }
    public StatusAppoinment getEstado() { return estado; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
    public String getObservaciones() { return observaciones; }
}
