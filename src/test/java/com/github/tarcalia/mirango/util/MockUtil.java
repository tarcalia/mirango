package com.github.tarcalia.mirango.util;

import com.github.tarcalia.mirango.entity.Company;
import com.github.tarcalia.mirango.entity.Employee;

import java.util.List;
import java.util.UUID;

public class MockUtil {
    public static final String TEST_COMPANY_NAME = "Mirango";
    public static final UUID TEST_COMPANY_ID = UUID.randomUUID();
    public static final String TEST_EMPLOYEE_NAME = "Test Janos";
    public static final UUID TEST_EMPLOYEE_ID = UUID.randomUUID();

    public static Company getCompany() {
        var company = new Company();
        company.setName(TEST_COMPANY_NAME);
        company.setEmployees(List.of());
        return company;
    }

    public static Employee getEmployee() {
        var employee = new Employee();
        employee.setName(TEST_EMPLOYEE_NAME);
        employee.setCompanyId(TEST_COMPANY_ID);
        return employee;
    }
}
