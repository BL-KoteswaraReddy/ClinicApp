package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
public class AuditLogger
{
   static ArrayList<AuditLog> logs = new ArrayList<>();
    public static void displayLogs()
    {
        if(logs.isEmpty())
        {
            System.out.println("No logs are available");
            return;
        }
       for(AuditLog log: logs)
       {
           System.out.println(log);
       }

    }

    public static void log(String message, String level) {
        AuditLog auditLog = new AuditLog(LocalDateTime.now(), message, level);
        logs.add(auditLog);
    }
}