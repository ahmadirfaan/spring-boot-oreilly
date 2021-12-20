
package com.irfaan.learningspringoreilly.repositories;

import com.irfaan.learningspringoreilly.entities.Officer;
import com.irfaan.learningspringoreilly.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: OfficerDataRepository.java, v 0.1 2021‐12‐20 17.22 Ahmad Irfaan Hibatullah Exp $$
 */
public interface OfficerDataRepository extends JpaRepository<Officer, Integer> {
    List<Officer> findByRank(Rank rank);
    List<Officer> findByLastNameLikeAndRank(String like, Rank rank);
}