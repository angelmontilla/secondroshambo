/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:08:09
 */
package angel.roshambo.second.dtoacumulate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Angel
 */
public class DtoAcumulateTest {
    
    public DtoAcumulateTest() {
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
     * Test of getTotalRounds method, of class DtoAcumulate.
     */
    @Test
    public void testGetTotalRounds() {
        System.out.println("getTotalRounds");
        DtoAcumulate instance = new DtoAcumulate();
        long expResult = 0L;
        long result = instance.getTotalRounds();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalFirstWin method, of class DtoAcumulate.
     */
    @Test
    public void testGetTotalFirstWin() {
        System.out.println("getTotalFirstWin");
        DtoAcumulate instance = new DtoAcumulate();
        long expResult = 0L;
        long result = instance.getTotalFirstWin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalSecondWin method, of class DtoAcumulate.
     */
    @Test
    public void testGetTotalSecondWin() {
        System.out.println("getTotalSecondWin");
        DtoAcumulate instance = new DtoAcumulate();
        long expResult = 0L;
        long result = instance.getTotalSecondWin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalDraws method, of class DtoAcumulate.
     */
    @Test
    public void testGetTotalDraws() {
        System.out.println("getTotalDraws");
        DtoAcumulate instance = new DtoAcumulate();
        long expResult = 0L;
        long result = instance.getTotalDraws();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTotalRounds method, of class DtoAcumulate.
     */
    @Test
    public void testSetTotalRounds() {
        System.out.println("setTotalRounds");
        long totalRounds = 0L;
        DtoAcumulate instance = new DtoAcumulate();
        instance.setTotalRounds(totalRounds);
        assertEquals(instance.getTotalRounds(), totalRounds);
    }

    /**
     * Test of setTotalFirstWin method, of class DtoAcumulate.
     */
    @Test
    public void testSetTotalFirstWin() {
        System.out.println("setTotalFirstWin");
        long totalFirstWin = 0L;
        DtoAcumulate instance = new DtoAcumulate();
        instance.setTotalFirstWin(totalFirstWin);
        assertEquals(instance.getTotalFirstWin(), totalFirstWin);
    }

    /**
     * Test of setTotalSecondWin method, of class DtoAcumulate.
     */
    @Test
    public void testSetTotalSecondWin() {
        System.out.println("setTotalSecondWin");
        long totalSecondWin = 0L;
        DtoAcumulate instance = new DtoAcumulate();
        instance.setTotalSecondWin(totalSecondWin);
        assertEquals(instance.getTotalSecondWin(), totalSecondWin);
    }

    /**
     * Test of setTotalDraws method, of class DtoAcumulate.
     */
    @Test
    public void testSetTotalDraws() {
        System.out.println("setTotalDraws");
        long totalDraws = 0L;
        DtoAcumulate instance = new DtoAcumulate();
        instance.setTotalDraws(totalDraws);
        assertEquals(instance.getTotalDraws(), totalDraws);
    }

    /**
     * Test of equals method, of class DtoAcumulate.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        DtoAcumulate instance = new DtoAcumulate();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of canEqual method, of class DtoAcumulate.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        DtoAcumulate instance = new DtoAcumulate();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class DtoAcumulate.
     */
    @Ignore
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DtoAcumulate instance = new DtoAcumulate();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DtoAcumulate.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtoAcumulate instance = new DtoAcumulate();
        String expResult = "DtoAcumulate(totalRounds=0, totalFirstWin=0, totalSecondWin=0, totalDraws=0)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }    
}
