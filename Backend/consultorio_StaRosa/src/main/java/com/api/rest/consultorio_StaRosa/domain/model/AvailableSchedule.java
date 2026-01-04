package com.api.rest.consultorio_StaRosa.domain.model;

import java.time.LocalTime;

public class AvailableSchedule {
    private final Long id;
    private final int dayOfWeek;
    private final LocalTime start;
    private final LocalTime end;

    public AvailableSchedule(Long id, int dayOfWeek, LocalTime start, LocalTime end) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
    }

    public Long getId() { return id; }
    public int getDayOfWeek() { return dayOfWeek; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
}
