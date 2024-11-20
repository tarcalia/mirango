package com.github.tarcalia.mirango.service;

import java.util.Optional;
import java.util.UUID;

//todo add javadoc
public interface GenericService<T, K> {

    K save(T entity);

    Optional<K> findById(UUID id);

    void deleteById(UUID id);
}
