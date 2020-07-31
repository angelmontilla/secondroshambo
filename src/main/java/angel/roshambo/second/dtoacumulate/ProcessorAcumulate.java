/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 2:04:33
 */
package angel.roshambo.second.dtoacumulate;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angel
 */
@Service
public class ProcessorAcumulate {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ListenerAcumulate listener;

    public void register(ListenerAcumulate listener) {
        this.listener = listener;
    }

    public void onEvent(DtoAcumulate event) {
        if (listener != null) {            
            listener.OnData(event);
        }
    }

    public void onComplete() {
        if (listener != null) {
            listener.processComplete();
        }
    }

    @KafkaListener(topics = "acumulates", groupId = "group_id")
    public void consume(DtoAcumulate message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        onEvent(message);
    }
}
