package com.hejazi.boostan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        String[] newArgs = new String[2];
        Console console = System.console();
        System.out.println("The database username :");
        newArgs[0] = new String("--spring.datasource.username=" +
                console.readLine());
        newArgs[1] = new String("--spring.datasource.password=" +
                String.copyValueOf(console.readPassword("Enter your secret password: ")));
        SpringApplication.run(Main.class, newArgs);
    }
}
