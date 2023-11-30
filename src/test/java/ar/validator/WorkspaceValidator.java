package ar.validator;

import api.model.WorkspaceResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class WorkspaceValidator {
    public static void validate(){
        WorkspaceResponse[] response = (WorkspaceResponse[]) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response[0].getId(), "El campo ID es nulo");
    }
}
