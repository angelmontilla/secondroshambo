/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 0:53:17
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.enums.MoveEnum;
import angel.roshambo.second.enums.ResultEnum;
import angel.roshambo.second.winerstrategy.IWinnerStrategy;

import angel.roshambo.second.winerstrategy.RockStrategy;
import angel.roshambo.second.winerstrategy.ScissorsStrategy;
import angel.roshambo.second.winerstrategy.WinerStrategy;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;
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

/**
 *
 * @author Angel
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RepoResultTest {
    
    @Autowired
    private RepoResult repoResult;
    
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
    public void testGetScores() {
        System.out.println("getScores");
        
        this.repoResult.clear();
        
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
            
            this.repoResult.insertMove(dtoResult);                        
        }
        
        assertEquals(this.repoResult.getScores(id[0]).count(),countU1);        
    }
    
    /**
     * Test of insertMove method, of class RepoResult.
     */
    @Test
    public void testGetScoresFromNull() {
        System.out.println("getScores");
        
        this.repoResult.clear();
        
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
            
            this.repoResult.insertMove(dtoResult);                        
        }
        
        assertNotEquals(this.repoResult.getScores(null).count(),countU1);        
    }    
    
    /**
     * Test of getCounts method, of class RepoResult.
     */
    @Test
    public void testGetCounts() {
        System.out.println("getCounts");
        
        this.repoResult.clear();

        DtoResult dtoResult = new DtoResult(UUID.randomUUID() ,new java.util.Date(System.currentTimeMillis()),MoveEnum.PAPER,MoveEnum.PAPER,ResultEnum.DRAW);

        this.repoResult.insertMove(dtoResult);
        this.repoResult.insertMove(dtoResult);
        this.repoResult.insertMove(dtoResult);
        dtoResult = new DtoResult(UUID.randomUUID() ,new java.util.Date(System.currentTimeMillis()),MoveEnum.ROCK,MoveEnum.PAPER,ResultEnum.SECOND);
        this.repoResult.insertMove(dtoResult);
        this.repoResult.insertMove(dtoResult);
        this.repoResult.insertMove(dtoResult);
        this.repoResult.insertMove(dtoResult);
        
        Map<ResultEnum, Long> expResult = new HashMap<>();
        expResult.put(ResultEnum.DRAW, 3L);
        expResult.put(ResultEnum.SECOND, 4L);
        
        Map<ResultEnum, Long> result = this.repoResult.getCounts();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRounds method, of class RepoResult.
     */
    @Test
    public void testGetCounts2() {
        System.out.println("getCounts2");
        
        this.repoResult.clear();
        
        UUID id[] = new UUID[10];
        
        for (int i=0;i<10;i++)
            id[i]=UUID.randomUUID();
        
        DtoResult dtoResult;
        Random r1 = new Random();    
        
        IWinnerStrategy rockStrategy = new RockStrategy();
        IWinnerStrategy paperStrategy = new RockStrategy();
        IWinnerStrategy scissStrategy = new ScissorsStrategy();
        WinerStrategy strategy = new WinerStrategy();
        
        long countFirsts=0;
        long countSeconds=0;
        long countDraws=0;
        
        for (int i=0;i<10000;i++) 
        {
            int rand = r1.nextInt(10);            
                        
            MoveEnum f = MoveEnum.values()[r1.nextInt(3)];
            MoveEnum s = MoveEnum.values()[r1.nextInt(3)];
            ResultEnum r = ResultEnum.UNKNOWED;
            
            if (null!=f)
                switch (f) {
                case ROCK:
                    strategy.Context(rockStrategy);
                    break;
                case PAPER:
                    strategy.Context(paperStrategy);
                    break;
                case SCISSORS:
                    strategy.Context(scissStrategy);
                    break;
                default:
                    break;
            }
            
            if (null!=s) 
                switch (s) {
                case ROCK:
                    r = ResultEnum.valueOf(strategy.executeStrategy("ROCK"));
                    break;
                case PAPER:
                    r = ResultEnum.valueOf(strategy.executeStrategy("PAPER"));
                    break;
                case SCISSORS:
                    r = ResultEnum.valueOf(strategy.executeStrategy("SCISSORS"));
                    break;
                default:
                    break;
            }
            
            dtoResult = new DtoResult(id[rand],
                        new java.util.Date(System.currentTimeMillis()),
                        f, s, r);

            if (null!=r)
                switch (r) {
                case FIRST:
                    countFirsts++;
                    break;
                case SECOND:
                    countSeconds++;
                    break;
                case DRAW:
                    countDraws++;
                    break;
                default:
                    break;
            }
                        
            this.repoResult.insertMove(dtoResult);                        
        }
        
        Map<ResultEnum, Long> expResult = new HashMap<>();
        expResult.put(ResultEnum.FIRST, countFirsts);
        expResult.put(ResultEnum.SECOND, countSeconds);
        expResult.put(ResultEnum.DRAW, countDraws);
        
        assertEquals(expResult, this.repoResult.getCounts());
    }

}
