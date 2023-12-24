package com.goutam.backend.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class LogAspect {


//    @Around(value="com.goutam.backend.aop.AppPointcut.controllerPointcut()")
//    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        final Logger logger = LoggerFactory.getLogger(proceedingJoinPoint.getTarget().getClass());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String className = proceedingJoinPoint.getTarget().getClass().getName();
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        Object[] args = proceedingJoinPoint.getArgs();
//        logger.info("Class= "+className+" Method= "
//                +methodName+"() "+" arguments= "+objectMapper.writeValueAsString(args));
//
//        Object object = proceedingJoinPoint.proceed();
//
//        logger.info("Class= "+className+" Method= "
//                +methodName+"() "+" response= "+objectMapper.writeValueAsString(object));
//
//        return object;
//    }
}
