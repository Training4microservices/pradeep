package com.training.springboot.service;
import com.training.springboot.repository.EmployeeRepository;
import com.training.springboot.model.Employee;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {



  @Autowired
  EmployeeRepository employeeRepository;



  public List getAllEmployees() {
    List employees = new ArrayList();
    employeeRepository.findAll().forEach(employee -> employees.add(employee));

    return employees;

  }

  public Employee getEmployeeById(int id) {
    return employeeRepository.findById(id).get();
  }


      public Double getEmployeeSal(int id)
      {
        Employee e=employeeRepository.findById(id).get();
        return e.getSalary();
      }
  public Double getAvgEmpSal()
  {
    List employees1 = new ArrayList();
    employeeRepository.findAll().forEach(employee -> employees1.add(employee));

    Double total = (Double) employees1.stream().collect(Collectors.averagingDouble(Employee::getSalary));
    System.out.println("Average Salary : "+total);
    return total;
  }


  public void saveOrUpdate(Employee employee) {
    employeeRepository.save(employee);
  }

  public void delete(int id) {
    employeeRepository.deleteById(id);
  }
  public Employee updateEmployee(String name, Integer id) {
    Optional<Employee> originalEmployee = employeeRepository.findById(id);
    Employee employee = originalEmployee.get();
    employee.setName(name);
    return employeeRepository.save(employee);
  }
}