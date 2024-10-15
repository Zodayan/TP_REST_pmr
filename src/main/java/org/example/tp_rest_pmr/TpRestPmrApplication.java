package org.example.tp_rest_pmr;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.function.Predicate.not;

@SpringBootApplication
public class TpRestPmrApplication {

    public static void main(String[] args) {

        System.out.println((char) java.util.stream.IntStream.range(0, (int) Character.toUpperCase(String.valueOf(true).charAt(0))).sum());
        SpringApplication.run(TpRestPmrApplication.class, args);
    }
}


