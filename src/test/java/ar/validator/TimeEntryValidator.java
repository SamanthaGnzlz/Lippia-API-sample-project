package ar.validator;

import api.model.TimeEntryResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class TimeEntryValidator {
    public static void validateId(){
        TimeEntryResponse response = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response.getId(), "El campo ID es nulo");
    }

    public static void validateDescription(String description) {
        TimeEntryResponse timeEntryResponse = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(timeEntryResponse.getDescription(), description, "Las descripciones no coinciden");
    }
}
