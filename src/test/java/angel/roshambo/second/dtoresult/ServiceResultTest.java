/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 1:13:33
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.dtoacumulate.DtoAcumulate;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 *
 * @author Angel
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceResultTest {
    
    @Autowired
    private ServiceResult theService;
    
    
    public ServiceResultTest() {
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
     * Test of getNewUUID method, of class ServiceResult.
     */
    @Test
    public void testGetNewUUID() {
        System.out.println("getNewUUID");
        ServiceResult instance = new ServiceResult();        
        String result = instance.getNewUUID();
        String expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of makeMove method, of class ServiceResult.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        String id = UUID.randomUUID().toString();
        String first = "ROCK";
        String second = "PAPER";
        ServiceResult instance = new ServiceResult();
        DtoResult expResult = new DtoResult();
        Mono<DtoResult> result = instance.makeMove(id, first, second);
        assertEquals(expResult, result);
        
        StepVerifier.create(result).expectNext(expResult).verifyComplete();

    }

    /**
     * Test of getTotalCounts method, of class ServiceResult.
     */
    @Test
    public void testGetTotalCounts() {
        System.out.println("getTotalCounts");
        ServiceResult instance = new ServiceResult();
        DtoAcumulate expResult = null;
        DtoAcumulate result = instance.getTotalCounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRounds method, of class ServiceResult.
     */
    @Test
    public void testGetRounds() {
        System.out.println("getRounds");
        String id = "";
        ServiceResult instance = new ServiceResult();
        Flux<DtoResult> expResult = null;
        Flux<DtoResult> result = instance.getRounds(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
