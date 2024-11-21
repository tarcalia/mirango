package com.github.tarcalia.mirango.util;


import com.github.tarcalia.mirango.entity.Company;
import com.github.tarcalia.mirango.entity.Employee;
import com.github.tarcalia.mirango.entity.PersistedEntity;
import com.github.tarcalia.mirango.entity.dto.CompanyDto;
import com.github.tarcalia.mirango.entity.dto.EmployeeDto;
import com.github.tarcalia.mirango.entity.dto.PersistedDto;
import org.springframework.stereotype.Service;

/**
 * Utility class to convert entity to dto / dto to entity.
 */
@Service
public class Converter<T, K> {

    public CompanyDto toDto(Company entity) {
        var result = toDtoPersistedValues(entity, CompanyDto.class);
        result.setEmployees(entity.getEmployees().stream().map(PersistedEntity::getName).toList());
        return result;
    }

    public EmployeeDto toDto(Employee entity) {
        var result = toDtoPersistedValues(entity, EmployeeDto.class);
        result.setCompany(entity.getCompanyId().toString());
        return result;
    }

    public  <K extends PersistedDto, T extends PersistedEntity> K toDtoPersistedValues(T entity, Class<K> dtoClass) {
        try {
            K dto = dtoClass.getDeclaredConstructor().newInstance();
            dto.setId(entity.getId());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setName(entity.getName());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DTO instance", e);
        }
    }
}
