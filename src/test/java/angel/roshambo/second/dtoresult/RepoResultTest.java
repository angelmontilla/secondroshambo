/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:53:17
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.enums.MoveEnum;
import angel.roshambo.second.enums.ResultEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;
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
public class RepoResultTest {
    
    public RepoResultTest() {
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
     * Test of insertMove method, of class RepoResult.
     */
    @Test
    public void testInsertMove() {
        System.out.println("insertMove");
        UUID id = UUID.randomUUID();
        DtoResult dtoResult = new DtoResult(id ,new java.util.Date(System.currentTimeMillis()),MoveEnum.PAPER,MoveEnum.PAPER,ResultEnum.DRAW);
        RepoResult instance = new RepoResult();
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);
        assertEquals(instance.getRounds(id).count(),2);
        
    }

    /**
     * Test of getCounts method, of class RepoResult.
     */
    @Test
    public void testGetCounts() {
        System.out.println("getCounts");
        DtoResult dtoResult = new DtoResult(UUID.randomUUID() ,new java.util.Date(System.currentTimeMillis()),MoveEnum.PAPER,MoveEnum.PAPER,ResultEnum.DRAW);
        RepoResult instance = new RepoResult();
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);
        dtoResult = new DtoResult(UUID.randomUUID() ,new java.util.Date(System.currentTimeMillis()),MoveEnum.ROCK,MoveEnum.PAPER,ResultEnum.SECOND);
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);
        Map<ResultEnum, Long> expResult = new HashMap<>();
        expResult.put(ResultEnum.DRAW, 3L);
        expResult.put(ResultEnum.SECOND, 4L);
        Map<ResultEnum, Long> result = instance.getCounts();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRounds method, of class RepoResult.
     */
    @Test
    public void testGetRounds() {
        System.out.println("getRounds");
        UUID id = UUID.randomUUID();
        DtoResult dtoResult = new DtoResult( id ,new java.util.Date(System.currentTimeMillis()),MoveEnum.PAPER,MoveEnum.PAPER,ResultEnum.DRAW);
        RepoResult instance = new RepoResult();
        instance.insertMove(dtoResult);
        dtoResult = new DtoResult(id ,new java.util.Date(System.currentTimeMillis()),MoveEnum.ROCK,MoveEnum.PAPER,ResultEnum.SECOND);
        instance.insertMove(dtoResult);
        instance.insertMove(dtoResult);        
        long expResult = 3L;
        Stream<DtoResult> result = instance.getRounds(id);
        assertEquals(expResult, result.count());
    }
    
}
