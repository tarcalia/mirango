package com.github.tarcalia.mirango.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tarcalia.mirango.repository.CompanyRepository;
import com.github.tarcalia.mirango.repository.EmployeeRepository;
import com.github.tarcalia.mirango.util.MockUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.github.tarcalia.mirango.util.MockUtil.TEST_EMPLOYEE_NAME;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerIngetrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateEmployee() throws Exception {
        //given
        var company = companyRepository.save(MockUtil.getCompany());
        var employee = MockUtil.getEmployee();
        employee.setCompanyId(company.getId());

        var json = objectMapper.writeValueAsString(employee);

        //when
        var result = mockMvc.perform(post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        //then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(TEST_EMPLOYEE_NAME));
    }

    @Test
    void shouldUpdateEmployee() throws Exception {
        //given
        var company = companyRepository.save(MockUtil.getCompany());
        var employee = MockUtil.getEmployee();
        employee.setCompanyId(company.getId());
        var id = employeeRepository.save(employee).getId();
        var newName = "Updated Employee";
        var employeeToBeUpdated = employeeRepository.findById(id).get();
        employeeToBeUpdated.setName(newName);

        var employeeJson = objectMapper.writeValueAsString(employeeToBeUpdated);

        //when
        ResultActions resultActions = mockMvc.perform(put("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson));

        //then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(newName));
    }

    @Test
    void shouldGetEmployeeById() throws Exception {
        //given
        var company = companyRepository.save(MockUtil.getCompany());
        var employee = MockUtil.getEmployee();
        employee.setCompanyId(company.getId());
        var id = employeeRepository.save(employee).getId();

        //when
        var result = mockMvc.perform(get("/api/employee/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
    }

    @Test
    void shouldDeleteEmployeeById() throws Exception {
        //given
        var company = companyRepository.save(MockUtil.getCompany());
        var employee = MockUtil.getEmployee();
        employee.setCompanyId(company.getId());
        var id = employeeRepository.save(employee).getId();
        //when
        var result = mockMvc.perform(delete("/api/employee/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
    }
}
