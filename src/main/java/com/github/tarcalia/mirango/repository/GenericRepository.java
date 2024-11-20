package com.github.tarcalia.mirango.repository;

import com.github.tarcalia.mirango.entity.PersistedEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

/**
 * Generic repository for {@link PersistedEntity}.
 */
public abstract class GenericRepository<T extends PersistedEntity, K> {
    public static final String PARAM = "param";
    @PersistenceContext
    protected EntityManager em;

    /**
     * Save a {@link PersistedEntity} into the database.
     * @param entity the entity to be saved.
     * @return the saved entity.
     */
    @Transactional
    public T save(T entity) {
        return em.merge(entity);
    }

    /**
     * Find {@link PersistedEntity} by id.
     * @param id the ID of the {@link PersistedEntity}.
     * @return the entity if it exists.
     */
    @Transactional
    public Optional<T> findById(K id) {
        try {
            return Optional.of(em.createNamedQuery(T.FIND_BY_ID + className(), getEntityClass())
                    .setParameter(PARAM, id)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    /**
     * Delete a {@link PersistedEntity} by id.
     * @param id the ID of the {@link PersistedEntity}.
     */
    @Transactional
    public void deleteById(K id) {
        em.createNamedQuery(T.DELETE_BY_ID + className(), getEntityClass())
                .setParameter(PARAM, id)
                .executeUpdate();
    }

    /**
     * Get the class of the entity.
     * @return the entity class.
     */
    protected abstract Class<T> getEntityClass();

    /**
     * Return the name of the class as String.
     * @return the class name.
     */
    private String className() {
        return getEntityClass().getSimpleName();
    }
}
