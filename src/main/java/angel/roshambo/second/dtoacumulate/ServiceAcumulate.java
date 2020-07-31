/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 1:43:48
 */
package angel.roshambo.second.dtoacumulate;

import angel.roshambo.second.dtoresult.ServiceResult;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 *
 * @author Angel
 */
@Service
public class ServiceAcumulate {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, DtoAcumulate> kafkaTemplate;
    
    @Autowired
    private ServiceResult theService;

    public ListenableFuture<SendResult<String, DtoAcumulate>> sendMessage(String topic, DtoAcumulate message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        return this.kafkaTemplate.send(topic, message);
     }

     @Scheduled(fixedDelay = 5000)
     public void getWeatherInfoJob() throws IOException {
        logger.info("generate fake weather event");
        // getting Event
        DtoAcumulate event = theService.getTotalCounts();
        sendMessage("acumulates", event);
     }
}
