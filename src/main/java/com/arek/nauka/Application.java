package com.arek.nauka;

import com.arek.nauka.users.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by Arek on 01.11.2017.
 */
@Configuration
@ComponentScan("com.arek.nauka")
@EnableAspectJAutoProxy
public class Application {

    @Bean
    public Student student(){
        Student student = new Student();
        student.setName("John");
        student.setAge(20);
        return student;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Student student = context.getBean(Student.class);
        student.getAge();

        student.raiseException();



    }
}
