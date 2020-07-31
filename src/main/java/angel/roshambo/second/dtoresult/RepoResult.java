
package angel.roshambo.second.dtoresult;


import angel.roshambo.second.enums.ResultEnum;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

/**
 * <strong>RepoResult</strong> Repository for moves storing
 * <p>It's a component (singleton)<br/>it allows insert, counting and <br>
 * getting scores for an identified user</p>
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
    public Map<ResultEnum, Long> getCounts() {   
        return this.storing
                .stream()
                .parallel()
                .collect(Collectors
                            .groupingBy(DtoResult::getResult, Collectors.counting())
                );

    }
    
    /**
     * <b>getScores</b> getScores for an User
     * @param id - UUID for user
     * @return Flux of DtoResult stream
     */
    public Stream<DtoResult> getScores(UUID id) {
        return this.storing.stream()
                .filter(c -> c.getId().equals(id))
                .sorted(Comparator.comparing(DtoResult::getDate));
    }
    
    /**
     * <strong>clear</strong>
     * <p>Empty move contents</p>
     * <p>For testing only</p>
     */
    public void clear() {
        this.storing.clear();
    }
}
