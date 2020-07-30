/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:38:56
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.enums.MoveEnum;
import angel.roshambo.second.enums.ResultEnum;
import java.util.Date;
import java.util.UUID;
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
public class DtoResultTest {
    
    public DtoResultTest() {
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
     * Test of getId method, of class DtoResult.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        DtoResult instance = new DtoResult();
        UUID g = UUID.randomUUID();
        instance.setId(g);
        String id = g.toString();
        UUID expResult = UUID.fromString(id);
        UUID result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class DtoResult.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        DtoResult instance = new DtoResult();
        Date expResult = new Date(System.currentTimeMillis());
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFPlayer method, of class DtoResult.
     */
    @Test
    public void testGetFPlayer() {
        System.out.println("getFPlayer");
        DtoResult instance = new DtoResult();
        MoveEnum expResult = MoveEnum.ROCK;
        instance.setFPlayer(expResult);
        MoveEnum result = instance.getFPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSPlayer method, of class DtoResult.
     */
    @Test
    public void testGetSPlayer() {
        System.out.println("getSPlayer");
        DtoResult instance = new DtoResult();
        MoveEnum expResult = MoveEnum.PAPER;
        instance.setSPlayer(expResult);
        MoveEnum result = instance.getSPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResult method, of class DtoResult.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        DtoResult instance = new DtoResult();
        ResultEnum expResult = ResultEnum.FIRST;
        instance.setResult(expResult);
        ResultEnum result = instance.getResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class DtoResult.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        DtoResult instance = new DtoResult();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of canEqual method, of class DtoResult.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        DtoResult instance = new DtoResult();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class DtoResult.
     */
    @Ignore
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DtoResult instance = new DtoResult();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DtoResult.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtoResult instance = new DtoResult();
        String expResult = "DtoResult(id=null, date=null, fPlayer=null, sPlayer=null, result=null)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
