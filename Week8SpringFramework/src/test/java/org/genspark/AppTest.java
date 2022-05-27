package org.genspark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.springframework.stereotype.Component;

/**
 * Unit test for simple App.
 */
@Component("SourceTest")
public class AppTest 
{
    Student stud;
    @BeforeEach
    void setUp()
    {
        //stud = new Student(1234, "John",null,null);
    }

    @Test
    public void testName()
    {
        stud = new Student(1234, "John",null,null);
        assertEquals(stud.getName(), "John");
        assertEquals(stud.getId(), 1234);
    }

    @AfterEach
    public void tearDown()
    {

    }
}
