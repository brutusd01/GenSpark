import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    GameManager gm;
    @BeforeEach
    void setUp() {


    }



    @Test
    void start() {
        Human player = new Human();
        Assertions.assertNotNull(gm.player);
        Assertions.assertNotNull(gm.map);
    }

    @Test
    void startTurn() {
        Assertions.assertNotNull(gm.player);
        Assertions.assertNotNull(gm.map);
    }

    @Test
    void startCombat() {
        Assertions.assertNotNull(gm.player);
    }

    @AfterEach
    void tearDown() {
    }
}