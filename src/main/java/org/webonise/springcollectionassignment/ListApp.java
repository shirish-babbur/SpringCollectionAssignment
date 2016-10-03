package org.webonise.springcollectionassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ListApp {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ListApp.class, args);
        Application application = context.getBean(Application.class);
        application.startApplication();
    }
}
