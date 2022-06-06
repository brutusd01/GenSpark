package com.genspark.SpringBootDemoApp.Dao;

import com.genspark.SpringBootDemoApp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<Employee,Integer>

{


}
