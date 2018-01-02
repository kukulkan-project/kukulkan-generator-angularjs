package mx.infotec.dads.kukulkan.generator.integration;

/**
 * Banner Generator Service
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public interface BannerService {

    /**
     * GenerateBanner generate a banner for Spring boot app
     * 
     * @param appName
     * @return Banner Text
     */
    String generateBanner(String appName);
}
