package com.example.demo.run;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(@Id Integer id, @NotEmpty String title, LocalDateTime startedOn, LocalDateTime endedOn,
        @Positive Integer miles, Location location, @Version Integer version) {

    public Run {
        if (!endedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("The run cannot end before it starts");
        }
    }

}
