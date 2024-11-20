package com.github.tarcalia.mirango.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Domain class for {@link Company}.
 */
@Entity
@Getter
@Setter
@Table(name = "company")
@NamedQuery(name = Company.FIND_BY_ID, query = """
    SELECT c FROM Company c WHERE c.id = :param
    """)
@NamedQuery(name = Company.DELETE_BY_ID, query = """
    DELETE FROM Company c WHERE c.id = :param
    """)
public class Company extends PersistedEntity {
    public static final String FIND_BY_ID = "findByIdCompany";
    public static final String DELETE_BY_ID = "deleteByIdCompany";

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;
}