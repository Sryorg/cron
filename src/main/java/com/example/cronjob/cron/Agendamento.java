package com.example.cronjob.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Agendamento {
    private static final Logger log = LoggerFactory.getLogger(Agendamento.class);

    public boolean isPrimo(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Scheduled(cron = "${spring.task.scheduling.cron}")
    public void printNumeroPrimo() {
        log.info("Contagem iniciada em {}, ", LocalDateTime.now());

        int count = 2;
        System.out.println("Números primos:");

        while (count <= 200) {
            if (isPrimo(count)) {
                System.out.println(count);
            }
            count++;
        }
    }
}
