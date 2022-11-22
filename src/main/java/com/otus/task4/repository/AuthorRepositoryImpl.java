package com.otus.task4.repository;

import com.otus.task4.model.entity.Author;
import com.otus.task4.repository.api.AuthorRepository;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
    }

    @Override
    public Author findById(Long id) {
        return entityManager.createQuery("SELECT a FROM Author a WHERE a.id = :id", Author.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .setParameter("id", id)
                .getSingleResult();
    }
}
