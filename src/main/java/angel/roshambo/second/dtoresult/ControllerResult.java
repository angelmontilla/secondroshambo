/*
 * Second RoShamBo
 * Creado el 30-jul-2020 a las 21:27:39
 */
package angel.roshambo.second.dtoresult;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Angel
 */
@RestController
@RequestMapping("/sndroshambo")
public class ControllerResult {
    
    @Autowired
    private ServiceResult theService;
    
    /**
     * <b>theInit</b> Start a new game
     * @param Id if given user just exists
     * @return String User UUID as string
     */
    @GetMapping("/playstart")
    @ResponseBody
    public String theInit(@RequestParam(value="id", required = false) String Id) {
        String res;
        
        if (Id == null || Id.isEmpty()) {
            res = theService.getNewUUID();
        } else {
            res = Id;
        }
        
        return res;
    }
    
    /**
     * <strong>playround</strong> Play a Round!
     * @param firstMove String represents first player move
     * @param secondMove String represents second player move
     * @param Id String with UUID from user
     * @return Mono of DtoResult with play result
     */
    @GetMapping("/playround/{Id}")
    @ResponseBody
    public Mono<DtoResult> theRound(@RequestParam(value="r1", required = true) String firstMove, @RequestParam(value="r2", defaultValue = "Rock") String secondMove, @PathVariable("Id") String Id) {
        Mono<DtoResult> res;
        
        return res;
    }
    
    /**
     * <strong>theScores</strong> Gives User Rounds Scores
     * @param Id UUID that represents the user
     * @return Flux of DtoResults for subscribe
     */
    @GetMapping("/scores/{Id}")
    @ResponseBody
    public Flux<DtoResult> theScores(@PathVariable("Id") String Id) {
        Flux<DtoResult> res;
        
        return res;
    }
    
    /**
     * <strong>handleError</strong>
     * @param ex
     * @return 
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public Mono<Object> handleError(Exception ex) {
        Object errorObject = new Object();
        return Mono.just(errorObject);
    }
    
}
