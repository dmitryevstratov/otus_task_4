package com.otus.task4.repository;

import com.otus.task4.model.entity.Book;
import com.otus.task4.model.entity.Comment;
import com.otus.task4.repository.api.CommentRepository;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAllByBookId(Long bookId) {
        return entityManager.createQuery("SELECT c FROM Comment c LEFT JOIN c.book b WHERE b.id = :bookId", Comment.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .setParameter("bookId", bookId)
                .getResultList();
    }

    @Override
    public Comment findCommentByIdInBookById(Long bookId, Long commentId) {
        return entityManager.createQuery("SELECT c FROM Comment c LEFT JOIN c.book b WHERE c.id = :commentId and b.id = :bookId", Comment.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .setParameter("commentId", commentId)
                .setParameter("bookId", bookId)
                .getSingleResult();
    }

    @Override
    public void deleteCommentByIdInBookById(Long bookId, Long commentId) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = :bookId", Book.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .setParameter("bookId", bookId)
                .getSingleResult();

        if (book != null) {
            entityManager.createQuery("DELETE FROM Comment c WHERE c.id = :commentId")
                    .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                    .setParameter("commentId", commentId)
                    .executeUpdate();
        }
    }

    @Override
    public Comment save(Long bookId, String comment) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = :bookId", Book.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .setParameter("bookId", bookId)
                .getSingleResult();

        if (book != null) {
            entityManager.createNativeQuery("INSERT INTO comment (text, id_book) VALUES (:text, :idBook)")
                    .setParameter("text", comment)
                    .setParameter("idBook", book.getId())
                    .executeUpdate();

            return book.getComments().get(book.getComments().size() - 1);
        }

        return null;
    }

    @Override
    public Comment update(Long commentId, String comment) {
        entityManager.createQuery("UPDATE Comment c SET c.text = :comment WHERE c.id = :id")
                .setParameter("id", commentId)
                .setParameter("comment", comment)
                .executeUpdate();

        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.id = :commentId", Comment.class)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .setParameter("commentId", commentId)
                .getSingleResult();
    }
}
