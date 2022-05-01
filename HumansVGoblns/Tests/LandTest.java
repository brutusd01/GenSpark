import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {

    Land land;
    @BeforeEach
    void setUp() {
        land = new Land();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void genGrid() {
    }

    @Test
    void spawnPlayer() {
        Assertions.assertNotNull(land.human);
    }

    @Test
    void genGoblins() {
        Assertions.assertEquals(land.goblinsLeft, 0);
    }


    @Test
    void movePlayer() {
        Assertions.assertNotNull(land.human);
    }


}