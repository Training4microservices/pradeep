package com.training.springboot.service;

import com.training.springboot.model.Employee;
import com.training.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {


    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployee_basic() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(new Employee(2,"Jake",4000.0)));
        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(4000.0, employees.get(0).getSalary());

    }

    @Test
    public void getAllEmployee_basic1() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(new Employee(3,"Charles",3000.0)));
        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(4000.0, employees.get(0).getSalary());

    }


}
