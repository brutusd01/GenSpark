package com.genspark.SpringBootDemoApp.Entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_staff")
public class Employee
{

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.AUTO) //Auto generates the id name
    private int id;
    private String name;
    private String role;

    public Employee()
        {

        }

    public Employee(String name, String role)
    {
//        this.id = id;
        this.name = name;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
