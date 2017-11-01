package com.arek.nauka.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
        System.out.println("Before adviced method");
    }
}
