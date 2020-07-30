/*
 * Second RoShamBo
 * Creado el 30-jul-2020 a las 21:30:31
 */
package angel.roshambo.second.dtoresult;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
}
