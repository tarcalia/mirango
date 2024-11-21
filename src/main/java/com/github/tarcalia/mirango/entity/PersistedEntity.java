package com.github.tarcalia.mirango.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Domain class for {@link PersistedEntity}.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class PersistedEntity implements Serializable {

    public static String FIND_BY_ID = "findById";
    public static String DELETE_BY_ID = "deleteById";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column
    String name;
    @CreationTimestamp
    @Column(name = "created_at", updatable=false)
    OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    OffsetDateTime modifiedAt;
    @Version
    Long version;
}
