package com.github.tarcalia.mirango.entity.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * General abstract class for DTO entities.
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class PersistedDto {
    private UUID id;
    private String name;
    private OffsetDateTime createdAt;
}