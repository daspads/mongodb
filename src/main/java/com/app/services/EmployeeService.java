package com.app.services;

import com.app.controller.EmployeeDTO;
import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(EmployeeDTO employeeDTO){
        Employee employee=new Employee(employeeDTO);
        employeeRepository.insert(employee);
        return employee;
    }
}