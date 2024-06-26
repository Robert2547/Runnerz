package com.example.demo.run;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // Rest API
    // CRUD: Create, Read, Update, Delete
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);

        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }

        return run.get();

    }

    // Post
    @ResponseStatus(HttpStatus.CREATED) // 201 (Created)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        runRepository.save(run);
    }

    // Put
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 (No Content)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.save(run);
    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 (No Content)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.deleteById(id);
        ;
    }

    @GetMapping("/location/{location}")
    public String findByLocation(@PathVariable String location) {
        return runRepository.findAllByLocation(location).toString();
    }
    

}
