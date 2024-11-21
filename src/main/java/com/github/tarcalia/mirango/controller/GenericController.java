package com.github.tarcalia.mirango.controller;

import com.github.tarcalia.mirango.entity.PersistedEntity;
import com.github.tarcalia.mirango.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

/**
 * Generic controller for {@link PersistedEntity}s.
 */
public abstract class GenericController<T, K, S extends GenericService<T, K>> {

    @Autowired
    private S service;

    @PostMapping
    public K create(@RequestBody T entity) {
        return service.save(entity);
    }

    @PutMapping
    public K update(@RequestBody T employee) {
        return service.save(employee);
    }

    @GetMapping("/{id}")
    public Optional<K> getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
