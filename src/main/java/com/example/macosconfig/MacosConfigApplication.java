package com.example.macosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MacosConfigApplication.class, args);
        String name = run.getEnvironment().getProperty("name");
        System.out.println(name);
    }

}
