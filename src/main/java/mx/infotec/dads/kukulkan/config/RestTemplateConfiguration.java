package mx.infotec.dads.kukulkan.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate Configuration for use along with the banner generator
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Configuration
public class RestTemplateConfiguration {
    private static final int TIMEOUT = (int) TimeUnit.SECONDS.toMillis(1);

    @Bean
    public RestTemplate restClientConfigurations() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT);
        clientHttpRequestFactory.setConnectionRequestTimeout(TIMEOUT);
        return clientHttpRequestFactory;
    }
}
