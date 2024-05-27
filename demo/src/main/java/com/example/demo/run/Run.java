package com.example.demo.run;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(Integer id, @NotEmpty String title, LocalDateTime startedOn, LocalDateTime endedOn, @Positive Integer miles,
        Location location) {

            public Run {
                if (!endedOn.isAfter(startedOn)) {
                    throw new IllegalArgumentException("The run cannot end before it starts");
                }
            }

}
