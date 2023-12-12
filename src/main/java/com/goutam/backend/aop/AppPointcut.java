package com.goutam.backend.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppPointcut {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerPointcut(){}

    /*@Pointcut("within(@org.springframework.stereotype.Service *)")
    public void servicePointcut(){}


    @Pointcut("execution(* com.goutam.backend..*(..))")
    public void forSpecificPackage(){}


    @Pointcut("forSpecificPackage() && (controllerPointcut() || servicePointcut())")
    public void addAllPointcut(){}*/

}
