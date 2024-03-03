package com.goutam.backend.Event;

import com.goutam.backend.dto.LogData;
import org.aspectj.bridge.IMessage;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class AuditEventPublisher {
    private ApplicationEventPublisher applicationEventPublisher;

    public AuditEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

    public void publishEvent(String message) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        dataMap.put("host",request.getHeader("host"));
        dataMap.put("user-agent",request.getHeader("User-Agent"));
        dataMap.put("message", message);

    applicationEventPublisher.publishEvent(new AuditEvent<LogData>(LogData.builder().data(dataMap).build()));

    }

}
