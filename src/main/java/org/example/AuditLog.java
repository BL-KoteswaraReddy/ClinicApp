package org.example;

import java.time.LocalDateTime;

//This class represents one log entry
public class AuditLog
{
    private LocalDateTime localDateTime;
    private String level;
    private String message;

    public AuditLog(LocalDateTime localDateTime, String level, String message) {
        this.localDateTime = localDateTime;
        this.level = level;
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getLevel() {
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
