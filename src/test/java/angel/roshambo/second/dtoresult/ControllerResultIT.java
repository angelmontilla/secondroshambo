/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 13:06:10
 */
package angel.roshambo.second.dtoresult;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.ExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 *
 * @author Angel
 */
@RunWith(SpringRunner.class)
@WebFluxTest(ControllerResult.class)
public class ControllerResultIT {
    
    
    @Autowired
    WebTestClient webTestClient;
    
    @Autowired
    private ServiceResult theService;
    
    @Autowired
    private RepoResult theRepository;
    
    
    public ControllerResultIT() {
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
     * Test of theInit method, of class ControllerResult.
     */
    @Test
    public void testTheInit() {
        System.out.println("theInit");
        
        UUID id = UUID.randomUUID();
        String sid = id.toString();
                
        webTestClient.get()
                .uri("/sndroshambo/playstart/" + sid)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo(sid);
    }
    
    /**
     * Test of theInit method, of class ControllerResult.
     */
    @Ignore
    @Test
    public void testTheInit1() {
        System.out.println("theInit");
        
        UUID id = UUID.randomUUID();
        String sid = id.toString();
                
        webTestClient.get()
                .uri("/sndroshambo/playstart")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult();
        
    }    

    /**
     * Test of theRound method, of class ControllerResult.
     */
    @Ignore
    @Test
    public void testTheRound() {
        System.out.println("theRound");
        String firstMove = "";
        String secondMove = "";
        String Id = "";
        ControllerResult instance = new ControllerResult();
        Mono<DtoResult> expResult = null;
        Mono<DtoResult> result = instance.theRound(firstMove, secondMove, Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of theScores method, of class ControllerResult.
     */
    @Ignore
    @Test
    public void testTheScores() {
        System.out.println("theScores");
        String Id = "";
        ControllerResult instance = new ControllerResult();
        Flux<DtoResult> expResult = null;
        Flux<DtoResult> result = instance.theScores(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleError method, of class ControllerResult.
     */
    @Ignore
    @Test
    public void testHandleError() {
        System.out.println("handleError");
        Exception ex = null;
        ControllerResult instance = new ControllerResult();
        Mono<Object> expResult = null;
        Mono<Object> result = instance.handleError(ex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
