package com.github.tarcalia.mirango.entity.dto;

import com.github.tarcalia.mirango.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Dto class for {@link Company} entity.
 */
@Getter
@Setter
@NoArgsConstructor
public class CompanyDto extends PersistedDto {
    private String name;
    private List<String> employees;
}
