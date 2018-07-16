package mx.infotec.dads.kukulkan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import mx.infotec.dads.kukulkan.metamodel.util.KukulkanConfigurationProperties;
import mx.infotec.dads.kukulkan.util.TemporalDirectoryUtil;

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
     * You can find more information on how profiles work with JHipster on <a href=
     * "http://jhipster.github.io/profiles/">http://jhipster.github.io/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {

    }

    /**
     * Method to exec at end the test
     */
    @PreDestroy
    public void destroy() {
        TemporalDirectoryUtil.deleteTemporalDir();
    }

}
