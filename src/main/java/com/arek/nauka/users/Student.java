package com.arek.nauka.users;

import org.springframework.stereotype.Component;

/**
 * Created by Arek on 01.11.2017.
 */

public class Student {
    private int age;
    private String name;

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        System.out.println("Age: " + age);
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        System.out.println("Name: " +name);
        return name;

    }

    public void raiseException(){
        System.out.println("Some Error");
        throw new IllegalArgumentException("illegal argument");
    }

}
