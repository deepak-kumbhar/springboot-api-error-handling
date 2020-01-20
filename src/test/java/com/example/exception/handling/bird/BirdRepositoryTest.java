package com.example.exception.handling.bird;

import static com.example.exception.handling.dto.BirdObjectMother.createCanary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exception.handling.repository.BirdRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BirdRepositoryTest {

    @Autowired
    private BirdRepository birdRepository;

    @Test
    public void canSaveBird() {
        birdRepository.save(createCanary());
    }

}