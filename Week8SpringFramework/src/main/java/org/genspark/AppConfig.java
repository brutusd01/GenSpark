package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {



    @Bean
    @Autowired
    public Address DAddress()
    {
        return new Address("Atlanta", "Georgia", "USA", "522354" );
    }

    @Bean
    public List DPhone()
    {
        List<String> list = new ArrayList();

        list.add("+1-000-000-0000");
        list.add("+1-000-123-4678");
        return list;
    }

    @Bean
    public Student DeeStudent()
    {
        return new Student(5890, "Dee Lin Quent", DPhone(), DAddress());
    }

}
