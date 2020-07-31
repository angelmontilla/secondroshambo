/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 1:13:33
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.dtoacumulate.DtoAcumulate;
import angel.roshambo.second.enums.MoveEnum;
import angel.roshambo.second.enums.ResultEnum;
import angel.roshambo.second.winerstrategy.IWinnerStrategy;
import angel.roshambo.second.winerstrategy.RockStrategy;
import angel.roshambo.second.winerstrategy.ScissorsStrategy;
import angel.roshambo.second.winerstrategy.WinerStrategy;
import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    
    @Autowired
    private RepoResult theRepository;
    
    
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

        String result = theService.getNewUUID();
        String expResult = result;
        
        assertEquals(expResult, result);

    }

    /**
     * Test of makeMove method, of class ServiceResult.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        
        UUID id = UUID.randomUUID();        
        
        DtoResult expResult = new DtoResult(id, new java.util.Date(System.currentTimeMillis()), MoveEnum.ROCK, MoveEnum.PAPER, ResultEnum.SECOND);
        
        //doNothing().when(theRepository).insertMove(expResult);
        
        Mono<DtoResult> result = theService.makeMove(id.toString(), "ROCK", "PAPER");
        
        StepVerifier.create(result)
                .thenAwait(Duration.ofSeconds(1))
                .assertNext((t) -> {
                    assertEquals(t.getId(), expResult.getId());
                    assertEquals(t.getFPlayer(), expResult.getFPlayer());
                    assertEquals(t.getSPlayer(), expResult.getSPlayer());
                    assertEquals(t.getResult(), expResult.getResult());
                })
                .verifyComplete();

    }

    /**
     * Test of getTotalCounts method, of class ServiceResult.
     */
    @Test
    public void testGetTotalCounts() {        
        System.out.println("getTotalCounts");
     
        theRepository.clear();
        
        UUID id[] = new UUID[10];
        
        for (int i=0;i<10;i++)
            id[i]=UUID.randomUUID();
        
        DtoResult dtoResult = null;
        Random r1 = new Random();    
        
        IWinnerStrategy rockStrategy = new RockStrategy();
        IWinnerStrategy paperStrategy = new RockStrategy();
        IWinnerStrategy scissStrategy = new ScissorsStrategy();
        WinerStrategy strategy = new WinerStrategy();
        
        int countU1=0;
        
        for (int i=0;i<1000;i++) 
        {
            int rand = r1.nextInt(10);
            
            if (rand==0)
                countU1++;
            
            MoveEnum f = MoveEnum.values()[r1.nextInt(2)];
            MoveEnum s = MoveEnum.values()[r1.nextInt(2)];
            
            if (f==MoveEnum.ROCK)
                strategy.Context(rockStrategy);
            if (f==MoveEnum.PAPER)
                strategy.Context(paperStrategy);
            if (f==MoveEnum.SCISSORS)
                strategy.Context(scissStrategy);
            
            if (s==MoveEnum.ROCK)
                dtoResult = new DtoResult(id[rand],
                            new java.util.Date(System.currentTimeMillis()),
                            f, s, ResultEnum.valueOf(strategy.executeStrategy("ROCK")));
            if (s==MoveEnum.PAPER)
                dtoResult = new DtoResult(id[rand],
                            new java.util.Date(System.currentTimeMillis()),
                            f, s, ResultEnum.valueOf(strategy.executeStrategy("PAPER")));
            if (s==MoveEnum.SCISSORS)
                dtoResult = new DtoResult(id[rand],
                            new java.util.Date(System.currentTimeMillis()),
                            f, s, ResultEnum.valueOf(strategy.executeStrategy("SCISSORS")));
            
            theRepository.insertMove(dtoResult);
        }        
        
        DtoAcumulate res = new DtoAcumulate();
        long total;
        
        theRepository.getCounts().forEach((k,v) -> {
            if (k==ResultEnum.FIRST)
                    res.setTotalFirstWin(v);
            if (k==ResultEnum.SECOND)
                    res.setTotalSecondWin(v);
            if (k==ResultEnum.DRAW)
                    res.setTotalDraws(v);            
        });
                      
        total = res.getTotalDraws()+res.getTotalFirstWin()+res.getTotalSecondWin();
        
        res.setTotalRounds(total);
        
        DtoAcumulate result = theService.getTotalCounts();
        
        assertEquals(res, result);
    }

    /**
     * Test of getRounds method, of class ServiceResult.
     */
    
    @Test
    public void testGetRounds() {
        System.out.println("getRounds");
                
        theRepository.clear();
        
        UUID id[] = new UUID[10];
        
        for (int i=0;i<10;i++)
            id[i]=UUID.randomUUID();
        
        DtoResult dtoResult = null;
        Random r1 = new Random();    
        
        IWinnerStrategy rockStrategy = new RockStrategy();
        IWinnerStrategy paperStrategy = new RockStrategy();
        IWinnerStrategy scissStrategy = new ScissorsStrategy();
        WinerStrategy strategy = new WinerStrategy();
        
        int countU1=0;
        
        for (int i=0;i<1000;i++) 
        {
            int rand = r1.nextInt(10);
            
            if (rand==0)
                countU1++;
            
            MoveEnum f = MoveEnum.values()[r1.nextInt(2)];
            MoveEnum s = MoveEnum.values()[r1.nextInt(2)];
            
            if (f==MoveEnum.ROCK)
                strategy.Context(rockStrategy);
            if (f==MoveEnum.PAPER)
                strategy.Context(paperStrategy);
            if (f==MoveEnum.SCISSORS)
                strategy.Context(scissStrategy);
            
            if (s==MoveEnum.ROCK)
                dtoResult = new DtoResult(id[rand],
                            new java.util.Date(System.currentTimeMillis()),
                            f, s, ResultEnum.valueOf(strategy.executeStrategy("ROCK")));
            if (s==MoveEnum.PAPER)
                dtoResult = new DtoResult(id[rand],
                            new java.util.Date(System.currentTimeMillis()),
                            f, s, ResultEnum.valueOf(strategy.executeStrategy("PAPER")));
            if (s==MoveEnum.SCISSORS)
                dtoResult = new DtoResult(id[rand],
                            new java.util.Date(System.currentTimeMillis()),
                            f, s, ResultEnum.valueOf(strategy.executeStrategy("SCISSORS")));
            
            theRepository.insertMove(dtoResult);

        }        
        
        Flux<DtoResult> result = theService.getRounds(id[0].toString());
        
//        StepVerifier.create(result)
//                .expectAccessibleContext()
//                
//                .assertNext((t) -> {
//                    assertEquals(t.getId(), id[0]);
//                })
//                .verifyComplete();    

        StepVerifier.create(result)
                .thenConsumeWhile(v -> {
                    assertEquals(v.getId(),id[0]);
                    return true;
                })
                .verifyComplete();

    }
    
}
