package com.example.springartical;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.springartical.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        log.info("{} is about to execute", joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.springartical.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        log.info("{} was executed", joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.example.springartical.service.*.*(..))",
            returning = "result"
    )
    public void afterReturn(JoinPoint joinPoint, Object result){
        log.info("{} has been executed by returning {}", joinPoint.getSignature().getName(), result);
    }

    @Around("execution(* com.example.springartical.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        log.info("{} returned : {}", joinPoint.getSignature().getName(), result);
        return result;
    }
}
