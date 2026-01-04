package com.api.rest.consultorio_StaRosa.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.api.rest.consultorio_StaRosa.domain.enums.StatusAppoinment;
import com.api.rest.consultorio_StaRosa.domain.exception.BusinessRuleViolationException;
import com.api.rest.consultorio_StaRosa.domain.exception.ScheduleConflictException;

public class Appointment {
    private final Long id;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private StatusAppoinment status;
    private final Patient patient;
    private final List<AppointmentItem> items;
    private String observations;
    private FollowUp followUp;

    public Appointment(Long id, LocalDate date, LocalTime startTime, LocalTime endTime, Patient patient) {
        if (endTime.isBefore(startTime)) {
            throw new ScheduleConflictException("La hora de fin no puede ser anterior al inicio");
        }
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patient;
        this.items = new ArrayList<>();
        this.status = StatusAppoinment.PROGRAMADA;
    }

    public void addProcedure(Procedure procedure, BigDecimal discount) {
        if (this.status.equals(StatusAppoinment.COMPLETADA)) {
            throw new BusinessRuleViolationException("No se pueden añadir procedimientos a una cita ya finalizada.");
        }
        this.items.add(new AppointmentItem(procedure.getId(), procedure.getBasePrice(), discount));
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(item -> item.getPriceAtTime().subtract(item.getDiscount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void complete(String procedureSummary, LocalDate nextSuggestedDate) {
        this.status = StatusAppoinment.COMPLETADA;
        this.followUp = new FollowUp(this.id, procedureSummary, nextSuggestedDate);
    }

    public Long getId() { return id; }
    public LocalDate getDate() { return date; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public StatusAppoinment getStatus() { return status; }
    public Patient getPatient() { return patient; }
    public List<AppointmentItem> getItems() { return items; }
    public String getObservations() { return observations; }
    public FollowUp getFollowUp() { return followUp; }
}
