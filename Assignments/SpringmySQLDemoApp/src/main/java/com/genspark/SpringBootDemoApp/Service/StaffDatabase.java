package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.Dao.StaffDao;
import com.genspark.SpringBootDemoApp.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StaffDatabase implements EmployeeService {

    @Autowired
    private StaffDao staff;
    @Override
    public List<Employee> getAllStaff() {
        return this.staff.findAll();
    }

    @Override
    public Optional<Employee> getStaff(int id)
    {
        return this.staff.findById(id);
    }

    @Override
    public Employee addStaff(Employee employee) {
        return this.staff.save(employee);
    }

    @Override
    public Employee updateStaff(Employee employee) {
        return this.staff.save(employee);
    }

    @Override
    public String deleteStaff(int id) {
         this.staff.deleteById(id);
        return String.format("Deleted Employee %s from Database successfully!",id);
    }

}
