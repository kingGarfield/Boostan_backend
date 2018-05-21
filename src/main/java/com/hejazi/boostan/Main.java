package com.hejazi.boostan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class Main {
    public static void main() {
        String[] args = new String[2];
        Console console = System.console();
        System.out.println("The database username :");
        args[0] = "--spring.datasource.username=" +
                console.readLine();
        args[1] = "--spring.datasource.password=" +
                String.copyValueOf(console.readPassword("Enter your secret password: "));
        SpringApplication.run(Main.class, args);
    }
}
