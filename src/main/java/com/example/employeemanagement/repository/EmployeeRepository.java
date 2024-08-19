package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();
    Employee getEmployeeById(int id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
