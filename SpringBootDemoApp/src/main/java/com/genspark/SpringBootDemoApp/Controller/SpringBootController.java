package com.genspark.SpringBootDemoApp.Controller;

import com.genspark.SpringBootDemoApp.Entity.Employee;
import com.genspark.SpringBootDemoApp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringBootController
{
    @Autowired
    private EmployeeService staffService;

    @GetMapping("/")
    public String Welcome()
    {
        return "<HTML><H1>Welcome to DeRose's Spring Boot Application!</H1></HTML>";
    }

    @GetMapping("/greet")
    public String Greet(
            @RequestParam(value = "name",
                    defaultValue = "John Doe")
                                    String name,
            @RequestParam(value = "age", defaultValue = "UNKNOWN")
                    String age)
    {
        return String.format("Hello there %s! Your age is %s, correct?", name, age);
    }

    @GetMapping("/staff")
    public List<Employee> getAllStaff()
    {
        return this.staffService.getAllStaff();
    }

    @GetMapping("/staff/{id}")
    public Employee getStaff(@PathVariable String id)
    {
        return this.staffService.getStaff(Integer.parseInt(id));
    }

    @PostMapping("/staff")
    public Employee addStaff(@RequestBody Employee staff)
    {
        return this.staffService.addStaff(staff);
    }
    @PutMapping("/staff")
    public Employee updateStaff(@RequestBody Employee staff)
    {
        return this.staffService.updateStaff(staff);
    }

    @DeleteMapping("/staff/{id}")
    public String deleteStaff(String id)
    {
        return this.staffService.deleteStaff(Integer.parseInt(id));
    }
}
