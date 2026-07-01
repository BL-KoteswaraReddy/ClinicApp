package org.example;

import java.time.LocalDateTime;

//This class represents one log entry
public class AuditLog
{
    private LocalDateTime localDateTime;
    private LogLevel level;
    private String message;

    public AuditLog(LocalDateTime localDateTime, String message, LogLevel level) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.level = level;

    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "localDateTime=" + localDateTime +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
