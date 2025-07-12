package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeAdvice() {
        System.out.println("[LOG] Method is about to be called.");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterAdvice() {
        System.out.println("[LOG] Method execution completed.");
    }
}
