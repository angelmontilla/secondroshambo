/*
 * Second RoShamBo
 * Creado el 31-jul-2020 a las 1:23:11
 */
package angel.roshambo.second;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 *
 * @author Angel
 */
@Configuration
public class CorsConfig implements WebFluxConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
          corsRegistry.addMapping("/**")
          .allowedOrigins("*")
          .maxAge(3600);
     }    
}
