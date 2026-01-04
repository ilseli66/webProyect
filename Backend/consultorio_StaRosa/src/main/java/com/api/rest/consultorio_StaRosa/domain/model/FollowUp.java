package com.api.rest.consultorio_StaRosa.domain.model;

import java.time.LocalDate;

public class FollowUp {
    private final Long appointmentId;
    private final String summary;
    private final LocalDate nextSuggestedDate;

    public FollowUp(Long appointmentId, String summary, LocalDate nextSuggestedDate) {
        this.appointmentId = appointmentId;
        this.summary = summary;
        this.nextSuggestedDate = nextSuggestedDate;
    }

    public Long getAppointmentId() { return appointmentId; }
    public String getSummary() { return summary; }
    public LocalDate getNextSuggestedDate() { return nextSuggestedDate; }
}
