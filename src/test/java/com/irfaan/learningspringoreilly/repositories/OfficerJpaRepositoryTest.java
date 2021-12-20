
package com.irfaan.learningspringoreilly.repositories;

import com.irfaan.learningspringoreilly.entities.Officer;
import com.irfaan.learningspringoreilly.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: OfficerJpaRepositoryTest.java, v 0.1 2021‐12‐20 15.57 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest
@Transactional
public class OfficerJpaRepositoryTest {
    @Qualifier("officerJpaRepositoryImpl")
    @Autowired
    private OfficerRepository officerRepository;

    @Autowired
    private JdbcTemplate template;

    private List<Integer> getIds() {
        return template.query("select id from officers", (rs, num) -> rs.getInt("id"));
    }

    @Test
    public void testSave() {
        Officer officer = new Officer(Rank.LIUTENANT, "Nyota", "Uhuru");
        officer = officerRepository.save(officer);
        assertNotNull(officer.getId());
    }

    @Test
    public void findOneThatExists() {
        getIds().forEach(id -> {
            Optional<Officer> officer = officerRepository.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id, officer.get().getId());
        });
    }

    @Test
    public void findOneThatDoesNotExist() {
        Optional<Officer> officer = officerRepository.findById(999);
        assertFalse(officer.isPresent());
    }

    @Test
    public void findAll() {
        List<String> dbNames = officerRepository.findAll().stream()
                .map(Officer::getLastName)
                .collect(Collectors.toList());
        assertThat(dbNames, containsInAnyOrder("Kirk", "Picard", "Sisko", "Janeway", "Archer"));
    }

    @Test
    public void count() {
        assertEquals(5, officerRepository.count());
    }

    @Test
    public void delete() {
        getIds().forEach(id -> {
            Optional<Officer> officer = officerRepository.findById(id);
            assertTrue(officer.isPresent());
            officerRepository.delete(officer.get());
        });
        assertEquals(0, officerRepository.count());
    }

    @Test
    public void existsById() {
        getIds().forEach(id -> assertTrue(officerRepository.existById(id)));
    }

    @Test
    public void doesNotExist() {
        List<Integer> ids = getIds();
        assertThat(ids, not(contains(999)));
        assertFalse(officerRepository.existById(999));
    }

}