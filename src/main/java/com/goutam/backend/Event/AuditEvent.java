package com.goutam.backend.Event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AuditEvent<T> extends ApplicationEvent {

    private T data;
    public AuditEvent(T event) {
        super(event);
        this.data = event;
    }
}
























//https://www.youtube.com/watch?v=XjiEoVOOsRg&ab_channel=CodeDebugger
