package org.webonise.springcollectionassignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

@Configuration
public class AppConfig {
    @Bean
    public HashSet<Users> getSetView() {
        return new HashSet<Users>();
    }

    @Bean
    public ArrayList<Users> getArrayList() {
        return new ArrayList<Users>();
    }

    @Bean
    public HashMap<Integer, Users> getHashMap() {
        return new HashMap<Integer, Users>();
    }

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ConsoleHandler getConsoleHandler() {
        return new ConsoleHandler();
    }
}
