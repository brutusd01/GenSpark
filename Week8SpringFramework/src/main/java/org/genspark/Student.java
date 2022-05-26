package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SudoStudent")
public class Student
{
    private int id;
    private String name;
    private List<Phone> phone;
    @Autowired
    private Address address;

    public void init()
    {
        System.out.println("Fetching student..");
    }

    public void destroy()
    {
        System.out.println("\nStudent got their bachelor's and left. [Destroy Method Called]");
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

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Student{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nphone=" + phone +
                ", \naddress=" + address +
                '}';
    }
}
