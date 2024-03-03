package com.goutam.backend.Event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goutam.backend.dto.LogData;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditEventHandler {

    @SneakyThrows
    @EventListener
    @Async
    public void handleEvent(AuditEvent<LogData> auditEvent) {
        //call audit api to save LogData

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(auditEvent.getData())
        );
    }
}
