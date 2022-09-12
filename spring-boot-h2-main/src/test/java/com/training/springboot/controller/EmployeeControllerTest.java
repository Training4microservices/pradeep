package com.training.springboot.controller;

import com.training.springboot.model.Employee;
import com.training.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private EmployeeService employeeService;


    @Test
    public void getAllEmployee() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(
                Arrays.asList()
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/employees")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andReturn();


    }

    @Test
    public void checkingEmployee() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(
                Arrays.asList(new Employee(2,"Jake",4000.0))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/employees")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:Jake,salary:4000.0}]"))
                .andReturn();


    }





}
