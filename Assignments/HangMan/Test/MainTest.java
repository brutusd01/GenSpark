import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    @BeforeEach
    void setUp()
    {
        main = new Main();
    }

    @Test
    void main() {
        assertNotNull(main.wordToGuess, "Player needs a name.");
    }

    @Test
    void ResetGame()
    {
        assertEquals(main.hiddenAnswer, "", "Hidden answer not reset.");
    }

    @AfterEach
    void tearDown() {
    }
}