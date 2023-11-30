package ar.steps;

import ar.validator.TimeEntryValidator;
import ar.validator.WorkspaceValidator;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;
import services.TimeEntryService;
import services.WorkspaceService;

public class ClockifySteps {
    @Given("^An account created in clockify and x-api-key generated$")
    public void anAccountCreatedInClockifyAndXApiKey() {
        BaseService.X_API_KEY.set(PropertyManager.getProperty("token"));
    }
    @And("I get a timeEntryID")
    public void iGetATimeEntryID() {
        TimeEntryService.defineTimeEntryID();
    }
    @And("^I set description to '(.*)'$")
    public void iSetDescriptionTo(String description) {
        BaseService.DESCRIPTION.set(description);
    }
    @And("I get a workspaceId")
    public void iGetAWorkspaceId() {
        WorkspaceService.defineWorkspaceId();
    }
    @Then("I obtain the data from the time entry")
    public void iObtainTheDataFromTheTimeEntry() {
        TimeEntryValidator.validateId();
    }
    @Then("I obtain the data from my workspace")
    public void iObtainTheDataFromMyWorkspace() {
        WorkspaceValidator.validate();
    }
    @And("^description is '(.*)'$")
    public void descriptionIs(String description) {
        TimeEntryValidator.validateDescription(description);
    }
}
