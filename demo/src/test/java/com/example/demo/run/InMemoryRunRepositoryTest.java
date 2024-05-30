package com.example.demo.run;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InMemoryRunRepositoryTest {

    InMemoryRunRepository repository;

    @BeforeEach
    void setup() {
        repository = new InMemoryRunRepository();
        repository.create(
                new Run(1, "First run", LocalDateTime.of(2021, 1, 1, 12, 0), LocalDateTime.of(2021, 1, 1, 13, 0), 5,
                        Location.INDOOR, 0));

        repository.create(new Run(2, "Second run", LocalDateTime.of(2021, 1, 2, 12, 0),
                LocalDateTime.of(2021, 1, 2, 13, 0), 10, Location.OUTDOOR, 0));
    }


    @Test 
    void shouldFindAllRuns()
    {
        List<Run> runs = repository.findAll();
        assertEquals(2, runs.size());
    }
}
