package com.example.springartical;

import com.example.springartical.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringArticalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(SpringArticalApplication.class, args);

        StudentService studentService =
                context.getBean(StudentService.class);

        studentService.getStudent();
    }

}
