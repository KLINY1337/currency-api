package com.test.task.sputnik.currency.api.currency.exchange.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.test.task.sputnik.currency.api.currency.exchange.controller.CurrencyExchangeController.*(..))")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        log.info("Calling method {} in class {}; Method arguments: {}", methodName, className, joinPoint.getArgs());
    }
}
