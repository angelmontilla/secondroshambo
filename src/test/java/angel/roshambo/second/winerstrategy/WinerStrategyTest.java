/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:32:00
 */
package angel.roshambo.second.winerstrategy;

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
public class WinerStrategyTest {
    
    public WinerStrategyTest() {
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
     * Test of Context method, of class WinerStrategy.
     */
    @Test
    public void testContext() {
        System.out.println("Context");
        IWinnerStrategy iWinnerStrategy = new RockStrategy();
        WinerStrategy instance = new WinerStrategy();
        instance.Context(iWinnerStrategy);
        instance.executeStrategy("ROCK");
        assertEquals(instance.executeStrategy("ROCK"), "DRAW");
    }

    /**
     * Test of executeStrategy method, of class WinerStrategy.
     */
    @Test
    public void testExecuteStrategy() {
        System.out.println("executeStrategy");
        String second = "ROCK";
        IWinnerStrategy iWinnerStrategy = new RockStrategy();
        WinerStrategy instance = new WinerStrategy();
        instance.Context(iWinnerStrategy);
        String expResult = "DRAW";
        String result = instance.executeStrategy(second);
        assertEquals(expResult, result);
    }    
}
