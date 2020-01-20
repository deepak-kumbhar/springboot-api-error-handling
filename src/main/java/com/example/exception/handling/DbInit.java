package com.example.exception.handling;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.exception.handling.dto.BirdObjectMother;
import com.example.exception.handling.repository.BirdRepository;

@Component
@Slf4j
@AllArgsConstructor
public class DbInit implements ApplicationRunner {

    private BirdRepository birdRepository;

    public void run(ApplicationArguments args) {
        log.info("Populating database with sample data...");
        birdRepository.save(BirdObjectMother.createCanary());
    }
}