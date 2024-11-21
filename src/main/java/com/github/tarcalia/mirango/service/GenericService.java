package com.github.tarcalia.mirango.service;

import com.github.tarcalia.mirango.entity.PersistedEntity;

import java.util.Optional;
import java.util.UUID;

/**
 * Generic service for {@link PersistedEntity}s.
 */
public interface GenericService<T, K> {

    K save(T entity);

    Optional<K> findById(UUID id);

    void deleteById(UUID id);
}
