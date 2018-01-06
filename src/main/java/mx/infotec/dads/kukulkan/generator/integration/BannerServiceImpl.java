/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2016 Daniel Cortes Pichardo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.kukulkan.generator.integration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * BannerServiceImpl.
 *
 * @author Daniel Cortes Pichardo
 */
@Service
public class BannerServiceImpl implements BannerService {
    
    /** The Constant BANNER_GENERATOR_URL. */
    private static final String BANNER_GENERATOR_URL = "https://devops.datenkollektiv.de/renderBannerTxt?text={appName}App&font=soft";
    
    /** The rest template. */
    @Autowired
    private RestTemplate restTemplate;

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.generator.integration.BannerService#generateBanner(java.lang.String)
     */
    @Override
    public Optional<String> generateBanner(String appName) {
        try {
            return Optional.of(restTemplate.getForObject(BANNER_GENERATOR_URL, String.class, appName));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
