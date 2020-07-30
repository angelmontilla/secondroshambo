
package angel.roshambo.second.dtoresult;


import angel.roshambo.second.dtoacumulate.DtoAcumulate;
import angel.roshambo.second.enums.ResultEnum;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * <strong>RepoResult</strong> Repository for moves storing
 * @author Angel
 */
@Component
public class RepoResult {
    
    private final CopyOnWriteArrayList<DtoResult> storing;
    
    /**
     * <b>RepoResult</b> Constructor thats assign data structure
     * <p>Concurrent Data Store, it worst for writing and updating<br> but
     * it is thread safe and solve several problems for this implementation</p>
     */
    RepoResult() {
        this.storing = new CopyOnWriteArrayList<>();
    }
    
    /**
     * <b>insertMove</b> Insert move in repository
     * <p>Moves are stored in first position using Deque interface</p>
     * @param dtoResult 
     */
    public void insertMove(DtoResult dtoResult) {
        this.storing.add(dtoResult);
    }
    
    /**
     * <b>getCounts</b> totals of first, second winners and draws.
     * @return DtoAcumulate with totals
     */
    public DtoAcumulate getCounts() {
        DtoAcumulate res = new DtoAcumulate();
        long total;
        
        Map<ResultEnum, Long> counts = this.storing.stream().parallel().
                collect(Collectors.groupingBy(DtoResult::getResult, Collectors.counting()));
        
        counts.forEach((k,v) -> {
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
     * <b>getDounds</b> getRounds from an User
     * @param id - UUID for user
     * @return Flux of DtoResult stream
     */
    public Flux<DtoResult> getRounds(UUID id) {
        return Flux.fromStream(this.storing.stream().
                                filter(c -> c.getId().equals(id)).
                                sorted(Comparator.comparing(DtoResult::getDate)));
    }
}
