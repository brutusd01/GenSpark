package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.Entity.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> getAllStaff();
    Employee getStaff(int id);
    Employee addStaff (Employee employee);
    Employee updateStaff(Employee employee);
    String deleteStaff(int id);
}
