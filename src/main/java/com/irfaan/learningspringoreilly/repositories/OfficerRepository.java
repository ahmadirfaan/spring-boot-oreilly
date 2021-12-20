package com.irfaan.learningspringoreilly.repositories;

import com.irfaan.learningspringoreilly.entities.Officer;

import java.util.List;
import java.util.Optional;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: OfficerRepository.java, v 0.1 2021‐12‐20 11.59 Ahmad Irfaan Hibatullah Exp $$
 */
public interface OfficerRepository {

    Officer save(Officer officer);

    Optional<Officer> findById(Integer id);

    List<Officer> findAll();

    long count();

    void delete(Officer officer);

    boolean existById(Integer id);


}