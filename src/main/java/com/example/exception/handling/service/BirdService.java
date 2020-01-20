package com.example.exception.handling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.handling.EntityNotFoundException;
import com.example.exception.handling.dto.Bird;
import com.example.exception.handling.dto.BirdCollection;
import com.example.exception.handling.repository.BirdRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    public Bird getBirdNoException(Long birdId) {
        return birdRepository.findOne(birdId);
    }

    public Bird getBird(Long birdId) {
        Bird bird = birdRepository.findOne(birdId);
        if (bird == null) {
            throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
        }
        return bird;
    }

    public Bird createBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public List<Bird> getBirdCollection(BirdCollection birdCollection) {
        List<Bird> birds = new ArrayList<>();

        for (Long birdId : birdCollection.getBirdsIds()) {
            Bird bird = birdRepository.findOne(birdId);
            if (bird == null) {
                throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
            }
            birds.add(bird);
        }
        return birds;
    }
}
