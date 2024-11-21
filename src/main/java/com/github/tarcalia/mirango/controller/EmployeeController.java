package com.github.tarcalia.mirango.controller;

import com.github.tarcalia.mirango.entity.Employee;
import com.github.tarcalia.mirango.entity.dto.EmployeeDto;
import com.github.tarcalia.mirango.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for {@link Employee} entities.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends GenericController<Employee, EmployeeDto, EmployeeService>{
}
