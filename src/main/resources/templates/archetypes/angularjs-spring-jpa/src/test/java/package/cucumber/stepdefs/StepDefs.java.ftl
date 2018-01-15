package ${project.packaging}.cucumber.stepdefs;

import ${project.packaging}.${project.id?cap_first}App;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = ${project.id?cap_first}App.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
