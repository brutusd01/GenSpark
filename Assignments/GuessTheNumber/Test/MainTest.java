import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.*;

class MainTest {

    Main main;
    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down..");
    }

    @Test
    void main() {
        assertNotNull(main.playerName, "Player needs a name.");
    }

    @Test
    void newGame() {
        assertEquals(0, main.guesses, "Guesses did not reset!");
    }

    @Test
    void attemptNumber() {
        assertNotNull(main.privateNum);
    }
}