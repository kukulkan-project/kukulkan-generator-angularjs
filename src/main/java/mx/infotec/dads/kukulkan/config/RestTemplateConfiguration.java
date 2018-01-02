package mx.infotec.dads.kukulkan.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate Configuration for use along with the banner generator
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate restTemplateConfiguratio(RestTemplateBuilder builder) {
        return builder.build();
    }

}
