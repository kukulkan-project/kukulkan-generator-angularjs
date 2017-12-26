package mx.infotec.dads.kukulkan.cucumber.stepdefs;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import mx.infotec.dads.kukulkan.engine.KukulkanEngineApp;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = KukulkanEngineApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
