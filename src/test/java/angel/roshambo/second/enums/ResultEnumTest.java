/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:29:57
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
public class ResultEnumTest {
    
    public ResultEnumTest() {
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
     * Test of values method, of class ResultEnum.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        ResultEnum[] expResult = {ResultEnum.FIRST, ResultEnum.SECOND, ResultEnum.DRAW, ResultEnum.UNKNOWED};
        ResultEnum[] result = ResultEnum.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class ResultEnum.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "DRAW";
        ResultEnum expResult = ResultEnum.DRAW;
        ResultEnum result = ResultEnum.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
