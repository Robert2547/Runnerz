package com.example.demo.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class JdbcClientRunRepository {

    // JDBC client
    private static final Logger log = LoggerFactory.getLogger(JdbcClientRunRepository.class);

    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // Pull from database
    public List<Run> findAll() {
        return jdbcClient.sql("select * from run")
                .query(Run.class).list();
    }

    // Find by ID
    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("select * from run where id = :id")
                .params("id", id)
                .query(Run.class)
                .optional();
    }

    // Create
    public void create(Run run) {
        var updated = jdbcClient
                .sql("INSERT INTO run (id,title, started_on, ended_on, miles, location) values (?, ?, ?, ?, ?, ?)")
                .params(List.of(run.id(), run.title(), run.startedOn(), run.endedOn(), run.miles(), run.location().toString()))
                .update();

        // Check if one row was updated, if didn't throw an exception
        Assert.state(updated == 1, "Failed to insert run " + run.title());
    }

    // Update
    public void update(Run run, Integer id) {
        var updated = jdbcClient
                .sql("update run set title= ?, started_on= ?, ended_on= ?, miles= ?, location where id = ?")
                .params(List.of(run.title(), run.startedOn(), run.endedOn(), run.miles(), run.location().toString(),
                        id))
                .update();

        Assert.state(updated == 1, "Failed to update run " + run.title());
    }

    // Delete
    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from run where id = :id")
                .params("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public void saveAll(List<Run> runs) // Save all runs
    {
        runs.stream().forEach(this::create);
    }

    // Count
    public int count() {
        return jdbcClient.sql("select * from run").query().listOfRows().size();
    }

    // Find by location
    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from run where location = :location")
                .params("location", location)
                .query(Run.class)
                .list();
    }

}
