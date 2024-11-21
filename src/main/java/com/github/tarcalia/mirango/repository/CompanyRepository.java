package com.github.tarcalia.mirango.repository;

import com.github.tarcalia.mirango.entity.Company;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Repository for {@link Company} entities.
 */
@Service
public class CompanyRepository extends GenericRepository<Company, UUID> {

    @Override
    protected Class<Company> getEntityClass() {
        return Company.class;
    }
}
