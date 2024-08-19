package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeJpaRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeRepository{

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public ArrayList<Employee> getEmployees() {
        List<Employee> employeeList = employeeJpaRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>(employeeList);
        return  employees;
    }

    public Employee getEmployeeById(int id) {
        try {
            Employee employee = employeeJpaRepository.findById(id).get();
            return employee;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Employee createEmployee(Employee employee) {
        employeeJpaRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(int id, Employee employee) {
        try{
            Employee exEmployee = employeeJpaRepository.findById(id).get();
            if(employee.getFirstName() != null){
                exEmployee.setFirstName(employee.getFirstName());
            }
            if(employee.getLastName() != null){
                exEmployee.setLastName(employee.getLastName());
            }
            if(employee.getEmail() != null){
                exEmployee.setEmail(employee.getEmail());
            }
            return employeeJpaRepository.save(exEmployee);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteEmployee(int id) {
        try {
            employeeJpaRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
