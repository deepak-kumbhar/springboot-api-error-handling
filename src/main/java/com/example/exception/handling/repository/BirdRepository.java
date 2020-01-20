package com.example.exception.handling.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.exception.handling.dto.Bird;

public interface BirdRepository extends CrudRepository<Bird, Long> {
}
