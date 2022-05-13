import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        assertNotNull(main.name, "Player needs a name.");
    }

    @Test
    void NewGame()
    {
        assertEquals(main.score, 0, "Score needs to be reset!");
    }

    @Test
    void PrintIntro() throws IOException {
        assertNotNull(Files.readString(Paths.get("src/Resources/Intro.txt")));
    }

    @AfterEach
    void tearDown() {
    }
}