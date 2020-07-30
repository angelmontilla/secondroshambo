/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:24:07
 */
package angel.roshambo.second.enums;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel
 */
public class MoveEnumTest {
    
    public MoveEnumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class MoveEnum.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        MoveEnum[] expResult = {MoveEnum.ROCK, MoveEnum.PAPER, MoveEnum.SCISSORS, MoveEnum.UNKNOWN};
        MoveEnum[] result = MoveEnum.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class MoveEnum.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "ROCK";
        MoveEnum expResult = MoveEnum.ROCK;
        MoveEnum result = MoveEnum.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
