package mx.infotec.dads.kukulkan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import mx.infotec.dads.kukulkan.util.TemporalDirectoryUtil;

//
//import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
//import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import mx.infotec.dads.kukulkan.metamodel.util.KukulkanConfigurationProperties;

@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties({ KukulkanConfigurationProperties.class })
public class KukulkanEngineApp {

    /**
     * Initializes kukulkancraftsman.
     * <p>
     * Spring profiles can be configured with a program arguments
     * --spring.profiles.active=your-active-profile
     * <p>
     * You can find more information on how profiles work with JHipster on
     * <a href=
     * "http://jhipster.github.io/profiles/">http://jhipster.github.io/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {

    }

    /**
     * Main method, used to run the application.
     *
     * @param args
     *            the command line arguments
     * @throws UnknownHostException
     *             if the local host name could not be resolved into an address
     */
    @PreDestroy
    public void destroy() {
        TemporalDirectoryUtil.deleteTemporalDir();
    }

}
