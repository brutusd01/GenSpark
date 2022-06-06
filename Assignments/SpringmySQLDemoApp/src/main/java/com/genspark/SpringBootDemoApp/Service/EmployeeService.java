package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    List<Employee> getAllStaff();
    Optional<Employee> getStaff(int id);
    Employee addStaff (Employee employee);
    Employee updateStaff(Employee employee);
    String deleteStaff(int id);
}
