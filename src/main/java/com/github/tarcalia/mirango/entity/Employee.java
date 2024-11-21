package com.github.tarcalia.mirango.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Domain class for {@link Employee}.
 */
@Entity
@Getter
@Setter
@NamedQuery(name = Employee.FIND_BY_ID, query = """
    SELECT e FROM Employee e WHERE e.id = :param
    """)
@NamedQuery(name = Employee.DELETE_BY_ID, query = """
    DELETE FROM Employee e WHERE e.id = :param
    """)
@Table(name = "employee")
@ToString
public class Employee extends PersistedEntity {
    public static final String FIND_BY_ID = "findByIdEmployee";
    public static final String DELETE_BY_ID = "deleteByIdEmployee";

    @Column(name = "company_id")
    private UUID companyId;
}
