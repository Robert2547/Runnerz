package com.example.demo.run;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface RunRepository extends ListCrudRepository<Run, Integer> {

    @Query("SELECT r FROM Run r WHERE r.location = :location")
    List<Run> findAllByLocation(@Param("location") String location);

}
