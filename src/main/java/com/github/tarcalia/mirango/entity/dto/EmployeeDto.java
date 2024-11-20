package com.github.tarcalia.mirango.entity.dto;

import com.github.tarcalia.mirango.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto class for {@link Employee} entity.
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto extends PersistedDto {
    private String name;
    private String company;
}
