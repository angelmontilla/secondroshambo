/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 1:55:05
 */
package angel.roshambo.second.dtoacumulate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

/**
 *
 * @author Angel
 */
@RestController
@RequestMapping("/sndroshambo")
public class ControllerAcumulate {
    
    @Autowired
    private ProcessorAcumulate processor;
    
    private Flux<DtoAcumulate> theBridge;
    
    public ControllerAcumulate() {
        // (3) Broadcast to several subscribers
        this.theBridge = createBridge().publish().autoConnect().cache(10).log();
    }
    
    // (1) Spring MVC annotation
    @GetMapping(value = "/acumulate", produces = "text/event-stream;charset=UTF-8")
    public Flux<DtoAcumulate> getScoreInfo() {
        return theBridge;
    }
    
    private Flux<DtoAcumulate> createBridge() {
        Flux<DtoAcumulate> bridge = Flux.create(sink -> { // (2)
            processor.register(new ListenerAcumulate() {

                @Override
                public void processComplete() {
                    sink.complete();
                }
            
                @Override
                public void OnData(DtoAcumulate data) {
                    sink.next(data);
                }
            });
        });
        
        return bridge;
    }
}
