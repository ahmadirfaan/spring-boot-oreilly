/**
 * Dana.id.
 * Copyright (c) 2017‐2021 All Rights Reserved.
 */
package com.irfaan.learningspringoreilly.repositories;

import com.irfaan.learningspringoreilly.entities.Officer;
import com.irfaan.learningspringoreilly.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: OfficerRepositoryTest.java, v 0.1 2021‐12‐20 13.44 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest
@Transactional // dengan menggunakan anotasi transaksional otomatis akan dirollback karena ini merupakan test
public class OfficerRepositoryTest {

    @Autowired
    private OfficerRepository officerRepository;

    @Test
    public void save() {
        Officer officer = new Officer(Rank.LIUTENANT, "Nyota", "Uhuru");
        officer = officerRepository.save(officer);
        assertNotNull(officer.getId());
    }

    @Test
    public void findByIdThatExists() {
        Optional<Officer> officer = officerRepository.findById(1);
        assertTrue(officer.isPresent());
        assertEquals(1, officer.get().getId().intValue());
    }

    @Test
    public void findByIdThatDoesNotExist() {
        Optional<Officer> officer = officerRepository.findById(999);
        assertFalse(officer.isPresent());
    }

    @Test
    public void count() {
        assertEquals(5, officerRepository.count());
    }

    @Test
    public void findAll() {
        List<String> dbNames = officerRepository.findAll().stream()
                .map(Officer::getLastName)
                .collect(Collectors.toList());
        assertThat(dbNames, containsInAnyOrder("Kirk", "Picard", "Sisko", "Janeway", "Archer"));
    }

    @Test
    public void delete() {
        IntStream.rangeClosed(1, 5)
                .forEach(id -> {
                    Optional<Officer> officer = officerRepository.findById(id);
                    assertTrue(officer.isPresent());
                    officerRepository.delete(officer.get());
                });
        assertEquals(0, officerRepository.count());
    }

    @Test
    public void existsById() {
        IntStream.rangeClosed(1, 5)
                .forEach(id -> assertTrue(officerRepository.existById(id)));
    }
}