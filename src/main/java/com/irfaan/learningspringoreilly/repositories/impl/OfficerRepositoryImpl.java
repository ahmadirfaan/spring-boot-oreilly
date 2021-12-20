/**
 * Dana.id.
 * Copyright (c) 2017‐2021 All Rights Reserved.
 */
package com.irfaan.learningspringoreilly.repositories.impl;

import com.irfaan.learningspringoreilly.entities.Officer;
import com.irfaan.learningspringoreilly.entities.Rank;
import com.irfaan.learningspringoreilly.repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: OfficerRepositoryImpl.java, v 0.1 2021‐12‐20 12.15 Ahmad Irfaan Hibatullah Exp $$
 */

@SuppressWarnings("ConstantConditions")
@Repository
public class OfficerRepositoryImpl implements OfficerRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;
    private final RowMapper<Officer> officerRowMapper = (rs, rowNum) ->
            new Officer(rs.getInt("id"),
                    Rank.valueOf(rs.getString("rank")),
                    rs.getString("first_name"),
                    rs.getString("last_name"));

    @Autowired
    public OfficerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officers")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Officer save(Officer officer) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("rank", officer.getRank());
        parameters.put("first_name", officer.getFirstName());
        parameters.put("last_name", officer.getLastName());
        Integer newId = (Integer) simpleJdbcInsert.executeAndReturnKey(parameters);
        officer.setId(newId);
        return officer;
    }

    @Override
    public Optional<Officer> findById(Integer id) {
        if(!existById(id)) return Optional.empty();
        return Optional.of(jdbcTemplate.queryForObject(
                "SELECT * FROM officers WHERE id=?", officerRowMapper,
                id
        ));
    }

    @Override
    public List<Officer> findAll() {
        return jdbcTemplate.query("SELECT * FROM officers", officerRowMapper);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from officers", Long.class);
    }

    @Override
    public void delete(Officer officer) {
        jdbcTemplate.update("DELETE FROM officers WHERE id=?", officer.getId());
    }

    @Override
    public boolean existById(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT EXISTS(SELECT 1 FROM officers where id=?)", Boolean.class, id);
    }
}