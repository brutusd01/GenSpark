package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Dialogue line;
    @BeforeEach
    void setUp() {
        line = new Dialogue();
    }

    @Test
    void testLine1() {
        assertEquals("%n" +
                "You are in a land full of dragons.%nIn front of you, you see two caves. " +
                "%nIn one cave, the dragon is friendly and will share his treasure with you." +
                "%nThe other dragon is greedy and hungry and will eat you on sight." +
                "%nWhich cave will you go into? (1 or 2)", line.line1, "Line of dialogue changed!");
    }

    @Test
    void testWin() {
        assertEquals("%nYou approach the cave.." +
                "%nYou find a big dragon on a pile of gold." +
                "%nThe dragon gives you a chest full of gold. Good job!", line.win, "Line of dialogue changed!");
    }

    @Test
    void testlose() {
        assertEquals("%n" +
                "You approach the cave.." +
                "%nIt is dark and spooky.. Like.. Very dark. You can't really see." +
                "%nA large dragon jumps out in front of you! He opens his jaw and.." +
                "%nYou got swallowed in one bite." , line.fail, "Line of dialogue changed!");
    }
    @Test
    void testMain()
    {
        assertEquals("", Main.input, "Dialgoue isn't blank!");
    }

    @AfterEach
    void tearDown() {
    }
}