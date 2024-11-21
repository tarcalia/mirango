package com.github.tarcalia.mirango.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Domain class for {@link Company}.
 */
@Entity
@Getter
@Setter
@Table(name = "company")
@NamedQuery(name = Company.FIND_BY_ID, query = """
    SELECT c FROM Company c LEFT JOIN FETCH c.employees e WHERE c.id = :param
    """)
@NamedQuery(name = Company.DELETE_BY_ID, query = """
    DELETE FROM Company c WHERE c.id = :param
    """)
@ToString
public class Company extends PersistedEntity {
    public static final String FIND_BY_ID = "findByIdCompany";
    public static final String DELETE_BY_ID = "deleteByIdCompany";

    @OneToMany(mappedBy = "companyId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Employee> employees;
}
