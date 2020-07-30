/*
 * Second RoShamBo
 * Creado el 30-jul-2020 a las 21:30:31
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.dtoacumulate.DtoAcumulate;
import angel.roshambo.second.enums.MoveEnum;
import angel.roshambo.second.enums.ResultEnum;
import angel.roshambo.second.winerstrategy.IWinnerStrategy;
import angel.roshambo.second.winerstrategy.PaperStrategy;
import angel.roshambo.second.winerstrategy.RockStrategy;
import angel.roshambo.second.winerstrategy.ScissorsStrategy;
import angel.roshambo.second.winerstrategy.WinerStrategy;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Angel
 */
@Service
public class ServiceResult {
    
    @Autowired
    RepoResult theRepository;
    
    /**
     * <b>getNewUUID</b> Get UUID for User
     * @return UUID as String
     */
    public String getNewUUID() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * <b>makeMove</b> making the move 
     * <p>move is stored in repository if correct</p>
     * @param id UUID from user
     * @param first move of user
     * @param second move of computer
     * @return Mono of DtoResult
     */
    public Mono<DtoResult> makeMove(String id, String first, String second) {
        DtoResult dtoResult = new DtoResult();
        UUID iId = UUID.fromString(id);
        Date f = new Date(System.currentTimeMillis());                
        MoveEnum me1;
        MoveEnum me2;
        
        try {
            me1 = MoveEnum.valueOf(first.toUpperCase());
        } catch (IllegalArgumentException e) {
            me1 = MoveEnum.UNKNOWN;
        }
        
        try {
            me2 = MoveEnum.valueOf(second.toUpperCase());
        } catch (IllegalArgumentException e) {
            me2 = MoveEnum.UNKNOWN;
        }
                
        if (me1 != MoveEnum.UNKNOWN && me2 != MoveEnum.UNKNOWN) {            
            WinerStrategy strategy = new WinerStrategy();
            IWinnerStrategy aplyStrategy = null;
            
            if (me1 == MoveEnum.ROCK)
                aplyStrategy = new RockStrategy();

            if (me1 == MoveEnum.PAPER)
                aplyStrategy = new PaperStrategy();

            if (me1 == MoveEnum.SCISSORS)
                aplyStrategy = new ScissorsStrategy();

            strategy.Context(aplyStrategy);
            
            dtoResult.setId(iId);
            dtoResult.setDate(f);
            dtoResult.setFPlayer(me1);
            dtoResult.setSPlayer(me2);            
            dtoResult.setResult(ResultEnum.valueOf(strategy.executeStrategy(second.toUpperCase())));
            
            theRepository.insertMove(dtoResult);
        } else {
            dtoResult.setId(null);
            dtoResult.setDate(null);
            dtoResult.setFPlayer(MoveEnum.UNKNOWN);
            dtoResult.setSPlayer(MoveEnum.UNKNOWN);
            dtoResult.setResult(ResultEnum.UNKNOWED);
        }
        
        return Mono.just(dtoResult);
    }
    
    /**
     * <b>getTotalCounts</b> Get Total from all gamers
     * @return DtoAcumulate Object with all totals
     */
    public DtoAcumulate getTotalCounts() {
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
        
        return res;
    }

    /**
     * <b>getRounds</b> get Rounds for an User
     * @param id String that represents User
     * @return Flux of DtoResult
     */
    public Flux<DtoResult> getRounds(String id) {
        return Flux.fromStream(theRepository.getRounds(UUID.fromString(id)));
    }
    
}
