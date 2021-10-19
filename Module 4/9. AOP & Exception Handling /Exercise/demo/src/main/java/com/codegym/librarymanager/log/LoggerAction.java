package com.codegym.librarymanager.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAction {
    private static final Logger logger = LoggerFactory.getLogger(LoggerAction.class);

    @After("execution(* com.codegym.librarymanager.service.*.*(..))")
    public void logAction(JoinPoint joinPoint){

        logger.info(joinPoint.getTarget().getClass().getSimpleName() + "." +
                joinPoint.getSignature().getName());
    }
}