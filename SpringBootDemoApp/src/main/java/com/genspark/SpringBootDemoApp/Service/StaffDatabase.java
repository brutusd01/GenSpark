package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class StaffDatabase implements EmployeeService {

    List<Employee> staff;


    public StaffDatabase() {
        staff = new ArrayList<>();
        staff.add(new Employee(101, "Ryan", "Software Engineer"));
        staff.add(new Employee(102, "GenSpark", "Hiring Manager"));
        staff.add(new Employee(103, "DeRose", "Full Stack Java Developer"));
    }

    public List<Employee> getAllStaff() {
        return staff;
    }

    public Employee getStaff(int id) {
        Employee e = null;
        for (Employee s:staff) {
            if(s.getId() == id) {
                e = s;
                break;
            }
        }
        return e;
    }

    public Employee getStaff(String name) {
        Employee e = null;
        for (Employee s:staff) {
            if(Objects.equals(s.getName(), name)) {
                e = s;
                break;
            }
        }
        return e;
    }

    public Employee addStaff(Employee employee) {
        staff.add(employee);
        return employee;
    }

    public Employee updateStaff(Employee employee) {
        String name = employee.getName();
        String role = employee.getRole();
        Employee e = null;
        for (Employee i: staff)
        {
            if(i.getId() == employee.getId())
            {
                i.setName(name);
                i.setRole(role);
                e=i;
                break;
            }
        }
        return e;
    }

    public String deleteStaff(int id) {
        for (Employee emp:staff) {
            if(emp.getId() == id) {
                staff.remove(emp);
                break;
            }
        }
        return String.format("Deleted Employee %s from Database successfully!",id);
    }

    public String deleteStaff(String name) {
        for (Employee emp:staff) {
            if(Objects.equals(emp.getName(), name)) {
                staff.remove(emp);
                break;
            }
        }
        return String.format("Deleted Employee '%s' from Database successfully!",name);
    }
}
