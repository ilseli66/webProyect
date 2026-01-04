package com.api.rest.consultorio_StaRosa.domain.model;

import java.time.LocalDateTime;

public class AgendaBlock {
    private final Long id;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String reason;

    public AgendaBlock(Long id, LocalDateTime start, LocalDateTime end, String reason) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.reason = reason;
    }

    public Long getId() { return id; }
    public LocalDateTime getStart() { return start; }
    public LocalDateTime getEnd() { return end; }
    public String getReason() { return reason; }
}
