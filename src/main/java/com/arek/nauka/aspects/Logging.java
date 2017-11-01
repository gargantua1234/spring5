package com.arek.nauka.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by Arek on 01.11.2017.
 */

@Component
@Aspect
public class Logging {
    @Pointcut("execution(* com.arek.nauka.users.Student.*(..))")
    public void selectAll(){}

    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Advice before method invocation");
    }

    @After("selectAll()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("Advice after  method invocation");
        System.out.println(joinPoint.getThis());
        Object[] args = joinPoint.getArgs();
        Stream.of(args)
                .forEach(arg -> System.out.println("Argument: "+ arg));

        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "selectAll()", returning = "retValue")
    public void afterReturningAdvice(Object retValue){
        System.out.println("advice activated after method returning value");
        System.out.println("Method returned value:" + retValue);
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "exception")
    public void afterExceptionAdvice(IllegalArgumentException exception){
        System.out.println("An error occurred: " + exception.getMessage());
    }
}
