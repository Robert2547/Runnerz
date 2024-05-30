package com.example.demo.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository //
public class InMemoryRunRepository {

    private List<Run> runs = new ArrayList();

    List<Run> findAll() { // Return all runs
        return runs;
    }

    Optional<Run> findById(Integer id) { // Return a run by its id
        return runs.stream().filter(run -> run.id().equals(id)).findFirst();
    }

    void create(Run run) { // Create a new run
        runs.add(run);
    }

    void update(Run run, Integer id) { // Update a run by its id
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent())
            runs.set(runs.indexOf(existingRun.get()), run);
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

   
}
