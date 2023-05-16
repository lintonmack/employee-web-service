package org.pdp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pdp.ApiMain;
import org.pdp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(classes = ApiMain.class)
public class EmployeeControllerTest {

    private static MockHttpServletRequest mockRequest;
    private static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockRequest = new MockHttpServletRequest();
    }

    @DisplayName("Get In Memory All Employees")
    @Test
    void getEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @DisplayName("Get Employee By Id Using In Memory Data")
    @Test
    void getEmployeeById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/employee?id=2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.employeeNumber").value(2))
                .andExpect(jsonPath("$.name").value("Bob"))
                .andExpect(jsonPath("$.gender").value("male"))
                .andExpect(jsonPath("$.address").value("2 Fake Street"))
                .andExpect(jsonPath("$.postcode").value("m1 3ay"))
                .andExpect(jsonPath("$.employeeNumber").value(2))
                .andExpect(jsonPath("$.department").value("PR"))
                .andExpect(jsonPath("$.salary").value(23000.0))
                .andExpect(jsonPath("$.email").value("notlinton@linton.com"));
    }

    @DisplayName("Insert Employee Into In Memory Data")
    @Test
    void insertEmployee() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)));

        Employee employee = new Employee("John", "male", "45 Fake Street", "m1 3ay", 1, "Tech", 20000.0f, "linton@linton.com");

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)));
    }

}
