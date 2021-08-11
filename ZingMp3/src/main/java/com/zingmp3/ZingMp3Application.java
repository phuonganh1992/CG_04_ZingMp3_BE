package com.zingmp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ZingMp3Application {

    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println(date);
        SpringApplication.run(ZingMp3Application.class, args);
    }

}
