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

import static com.github.tarcalia.mirango.util.MockUtil.TEST_COMPANY_NAME;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CompanyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateCompany() throws Exception {
        //given
        var company = MockUtil.getCompany();

        var companyJson = objectMapper.writeValueAsString(company);

        //when
        var result = mockMvc.perform(post("/api/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(companyJson));

        //then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(TEST_COMPANY_NAME));
    }

    @Test
    void shouldUpdateCompany() throws Exception {
        //given
        var id = companyRepository.save(MockUtil.getCompany()).getId();
        var newName = "Updated Company";
        var company = companyRepository.findById(id).get();
        company.setName(newName);

        var companyJson = objectMapper.writeValueAsString(company);

        //when
        ResultActions resultActions = mockMvc.perform(put("/api/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(companyJson));

        //then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(newName));
    }

    @Test
    void shouldGetCompanyById() throws Exception {
        //given
        var id = companyRepository.save(MockUtil.getCompany()).getId();

        //when
        var result = mockMvc.perform(get("/api/company/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
    }

    @Test
    void shouldDeleteCompanyById() throws Exception {
        //given
        var id = companyRepository.save(MockUtil.getCompany()).getId();
        //when
        var result = mockMvc.perform(delete("/api/company/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
    }
}
