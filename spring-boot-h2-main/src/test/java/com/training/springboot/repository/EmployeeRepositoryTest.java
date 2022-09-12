package com.training.springboot.repository;


import com.training.springboot.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {


    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testFindAll()
    {
        List<Employee> employees = repository.findAll();
        assertEquals(5,employees.size());
    }

    @Test
    public void testFindOne() {
        Employee employee = repository.findById(4).get();

        assertEquals("Terry",employee.getName());
    }




}
