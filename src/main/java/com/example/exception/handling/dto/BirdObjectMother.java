package com.example.exception.handling.dto;

public abstract class BirdObjectMother {

    public static Bird createCanary() {
        return Bird.builder()
                .scientificName("Atlantic canary")
                .specie("serinus canaria")
                .length(11)
                .mass(10d)
                .build();

    }
}
