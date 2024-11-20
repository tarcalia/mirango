package com.github.tarcalia.mirango.repository;

import com.github.tarcalia.mirango.entity.Company;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    @Transactional
    @Override
    public Company save(Company entity) {
        return em.merge(entity);
    }

    @Transactional
    @Override
    public Optional<Company> findById(UUID uuid) {
        return Optional.ofNullable(em.createNamedQuery(Company.FIND_BY_ID, Company.class)
                .setParameter("param", uuid)
                .getSingleResult());
    }

    @Transactional
    @Override
    public void deleteById(UUID uuid) {
        em.createNamedQuery(Company.DELETE_BY_ID)
                .setParameter("param", uuid)
                .executeUpdate();
    }
}
