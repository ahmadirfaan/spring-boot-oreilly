
package com.irfaan.learningspringoreilly.repositories;

import com.irfaan.learningspringoreilly.entities.Officer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: OfficerJpaRepositoryImpl.java, v 0.1 2021‐12‐20 15.49 Ahmad Irfaan Hibatullah Exp $$
 */

@SuppressWarnings("JpaQlInspection")
@Repository
public class OfficerJpaRepositoryImpl implements OfficerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Officer save(Officer officer) {
        entityManager.persist(officer);
        return officer;
    }

    @Override
    public Optional<Officer> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Officer.class, id));
    }

    @Override
    public List<Officer> findAll() {
        return entityManager.createQuery("select o from Officer o", Officer.class)
                .getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("select count(o.id) from Officer o", Long.class)
                .getSingleResult();
    }

    @Override
    public void delete(Officer officer) {
        entityManager.remove(officer);
    }

    @Override
    public boolean existById(Integer id) {
        Long count = entityManager.createQuery(
                        "select count(o.id) from Officer o where o.id=:id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }
}