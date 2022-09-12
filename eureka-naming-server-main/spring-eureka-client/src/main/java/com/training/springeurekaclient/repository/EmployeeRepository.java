package com.training.springeurekaclient.repository;

import com.training.springeurekaclient.model.Employee;
import com.training.springeurekaclient.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}