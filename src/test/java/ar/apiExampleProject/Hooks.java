package ar.apiExampleProject;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import services.TimeEntryService;

public class Hooks {

    @Before
    public void setScenario(Scenario scenario) {
        Logger.getRootLogger().info("-----------" + scenario.getName() + "-----------");
    }

    @After("@DeleteTimeEntryAfter")
    public void dismissAll(Scenario scenario) {
        TimeEntryService.delete("request/getTimeEntry");
        Logger.getRootLogger().info(" ending -----------" + scenario.getName() + "-----------");
    }
}
