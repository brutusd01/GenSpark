package org.genspark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Student stud;
    @BeforeEach
    void setUp()
    {
        stud = new Student();
    }

    @Test
    public void testName()
    {
        stud = new Student();
        stud.setName("John");
        stud.setId(1234);
        assertEquals(stud.getName(), "John");
        assertEquals(stud.getId(), 1234);
    }

    @AfterEach
    public void tearDown()
    {

    }
}
