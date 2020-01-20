package com.example.exception.handling.bird.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.exception.handling.EntityNotFoundException;
import com.example.exception.handling.dto.Bird;
import com.example.exception.handling.dto.BirdCollection;
import com.example.exception.handling.service.BirdService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping(value = "/{birdId}")
    public Bird getBird(@PathVariable("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/collection")
    public List<Bird> getBirdValid(@RequestBody BirdCollection birdCollection) throws EntityNotFoundException {
        return birdService.getBirdCollection(birdCollection);
    }

    @GetMapping(value = "/params")
    public Bird getBirdRequestParam(@RequestParam("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/noexception/{birdId}")
    public Bird getBirdNoException(@PathVariable("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBirdNoException(birdId);
    }


    @PostMapping
    public Bird createBird(@RequestBody @Valid Bird bird) {
        return birdService.createBird(bird);
    }

}
