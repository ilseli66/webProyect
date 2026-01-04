package com.api.rest.consultorio_StaRosa.domain.exception;

public class ScheduleConflictException extends DomainException {
    public ScheduleConflictException(String message) {
        super(message, "SCHEDULE_CONFLICT");
    }
}
