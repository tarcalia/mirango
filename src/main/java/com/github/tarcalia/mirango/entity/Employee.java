package com.github.tarcalia.mirango.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
public class Employee extends PersistedEntity {
    public static final String FIND_BY_ID = "findByIdEmployee";
    public static final String DELETE_BY_ID = "deleteByIdEmployee";

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}