package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Student getDStudent()
    {
        Student DStudent = new Student();
        DStudent.setName("Dee Lin Quent");
        DStudent.setId(5890);
        DStudent.setAddress(DAddress());
        DStudent.setPhone(DPhone());

        return DStudent;
    }

    @Bean
    public Address DAddress()
    {
        Address dAdress = new Address();
        dAdress.setCity("Atlanta");
        dAdress.setCountry("United States");
        dAdress.setState("Georgia");
        dAdress.setZipcode("58234");

        return dAdress;
    }

    @Bean
    public List DPhone()
    {
        List<String> list = new ArrayList();

        list.add("+1-000-000-0000");
        list.add("+1-000-123-4678");
        return list;
    }

}
