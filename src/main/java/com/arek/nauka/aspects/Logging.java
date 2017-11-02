package com.arek.nauka.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class Logging {

    private static final Logger LOG = LogManager.getLogger(Logging.class);

    @Pointcut("execution(* com.arek.nauka.users.Student.*(..))")
    public void selectAll(){}

    @Before("selectAll()")
    public void beforeAdvice(JoinPoint joinPoint){
        LOG.info("Calling method "+ joinPoint.getSignature());
        LOG.trace("Given method parameters: "+ Arrays.toString(joinPoint.getArgs()));

    }

    @After("@annotation(Loggable)")             //wersja wywolywania advice'a oznaczonego utworzona adnotacja
    public void afterAdvice(JoinPoint joinPoint){
        LOG.info("After calling method " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "@annotation(Loggable)", returning = "retValue") //jak wyzej oraz pobranie wartosc zwracanej przez
    public void afterReturningAdvice(Object retValue){                          //joinpointa
        LOG.debug("advice activated after method returning value");
        LOG.debug("Method returned value:" + retValue);
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "exception")
    public void afterExceptionAdvice(IllegalArgumentException exception){
        LOG.error("An error occurred: " + exception.getMessage());
    }
}
