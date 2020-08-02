/*
 * Second RoShamBo
 * Creado el 30-jul-2020 a las 21:27:39
 */
package angel.roshambo.second.dtoresult;

import angel.roshambo.second.dtoacumulate.DtoAcumulate;
import angel.roshambo.second.dtouser.DtoUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping({"/playstart/{Id}", "/playstart"})
    @ResponseBody
    public Mono<DtoUser> theInit(@PathVariable(name = "Id", required = false) String Id) {
        return theService.createUser(Id);
    }
    
    /**
     * <strong>playround</strong> Play a Round!
     * @param firstMove String represents first player move
     * @param secondMove String represents second player move
     * @param Id String with UUID from user
     * @return Mono of DtoResult with play result
     */
    @GetMapping("/playround/{Id}/{move1}/{move2}")
    @ResponseBody
    public Mono<DtoResult> theRound(@PathVariable("Id") String Id, @PathVariable("move1") String firstMove, @PathVariable("move2") String secondMove) {
        return theService.makeMove(Id, firstMove, secondMove);
    }
    
    /**
     * <strong>theScores</strong> Gives User Rounds Scores
     * @param Id UUID that represents the user
     * @return Flux of DtoResults for subscribe
     */
    @GetMapping({"/scores/{Id}", "/scores"} )
    @ResponseBody
    public Flux<DtoResult> theScores(@PathVariable(name= "Id", required = false) String Id) {
        Flux<DtoResult> response;
        
        if (Id != null) 
            response = theService.getRounds(Id);
        else
            response = Flux.empty();
        
        return response;
    }
    
    /**
     * <b>theTotalAccount</b> Gives total account
     * @return Mono of DtoAcumulate for subscribe
     */
    @GetMapping("/acumulates")
    @ResponseBody
    public Mono<DtoAcumulate> theAcmulate() {        
        return Mono.just(theService.getTotalCounts());
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
