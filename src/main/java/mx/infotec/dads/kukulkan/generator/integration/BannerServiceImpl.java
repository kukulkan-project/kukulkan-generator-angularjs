package mx.infotec.dads.kukulkan.generator.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * BannerServiceImpl
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String generateBanner(String appName) {
        return restTemplate.getForObject(
                "https://devops.datenkollektiv.de/renderBannerTxt?text=" + appName + "App&font=soft", String.class);
    }
}
