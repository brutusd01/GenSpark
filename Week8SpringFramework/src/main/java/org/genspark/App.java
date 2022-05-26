package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class App {


    public static void main(String[] args) {
        //XMLContainer();
        //AnnotationsContainer();
        JavaSourceContainer();
    }

    private static void XMLContainer() {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
        Student val = (Student) ctx.getBean("GoodyBStudent");
        System.out.println("\nThe student's name is.." + val.getName());
        System.out.println("\nVal to string output: \n" + val);
        ctx.close();
    }

    private static void AnnotationsContainer()
    {
        AbstractApplicationContext component = new ClassPathXmlApplicationContext("Spring.xml");
        Student sudo = (Student) component.getBean("SudoStudent");
        sudo.setName("Saluta Torian");
        sudo.setId(1040);
        ArrayList list = new ArrayList<>();
        list.add("+1-150-160-1880");
        sudo.setPhone(list);
        System.out.println("\nThe student's name is.." + sudo.getName());
        System.out.println("\nSudo to string output: \n" + sudo);
        component.close();
    }

    private static void JavaSourceContainer()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Student D = ctx.getBean(Student.class);
        System.out.println("\nThe student's name is.." + D.getName());
        System.out.println("\nD to string output: \n" + D);
    }
}
