package mx.infotec.dads.kukulkan.generator.integration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * BannerServiceImpl
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Service
public class BannerServiceImpl implements BannerService {
    private static final String BANNER_GENERATOR_URL = "https://devops.datenkollektiv.de/renderBannerTxt?text={appName}App&font=soft";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Optional<String> generateBanner(String appName) {
        try {
            return Optional.of(restTemplate.getForObject(BANNER_GENERATOR_URL, String.class, appName));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
