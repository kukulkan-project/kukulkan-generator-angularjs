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
package mx.infotec.dads.kukulkan.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate Configuration for use along with the BannerServiceImpl
 * {@link mx.infotec.dads.kukulkan.generator.integration.BannerServiceImpl#generateBanner(String)}
 *
 * @author Daniel Cortes Pichardo
 * @see mx.infotec.dads.kukulkan.generator.integration.BannerServiceImpl#generateBanner(String)
 */
@Configuration
public class RestTemplateConfiguration {
    
    /** The Constant TIMEOUT. */
    private static final int TIMEOUT = (int) TimeUnit.SECONDS.toMillis(1);

    /**
     * Rest client configurations.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restClientConfigurations() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    /**
     * Gets the client http request factory.
     *
     * @return the client http request factory
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT);
        clientHttpRequestFactory.setConnectionRequestTimeout(TIMEOUT);
        return clientHttpRequestFactory;
    }
}
