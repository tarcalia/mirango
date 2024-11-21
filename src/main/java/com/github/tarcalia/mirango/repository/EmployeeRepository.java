package com.github.tarcalia.mirango.repository;

import com.github.tarcalia.mirango.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Repository for {@link Employee} entities.
 */
@Service
public class EmployeeRepository extends GenericRepository<Employee, UUID> {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Transactional
    @Override
    public void deleteById(UUID uuid) {
        em.createNamedQuery(Employee.DELETE_BY_ID)
                .setParameter("param", uuid)
                .executeUpdate();
    }
}
