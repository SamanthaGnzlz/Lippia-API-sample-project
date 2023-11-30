package services;

import api.model.ClientResponse;
import api.model.TimeEntryResponse;
import api.model.WorkspaceResponse;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class TimeEntryService extends BaseService {
    public static Response post(String jsonName){
        return post(jsonName, TimeEntryResponse.class, setParams());
    }

    private static Map<String, String> setParams(){
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key", X_API_KEY.get());
        params.put("id-workspace", WORKSPACE_ID_0.get());
        return params;
    }

    public static void defineTimeEntryID() {
        TimeEntryResponse timeEntryResponses = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        TIME_ENTRY_ID.set(timeEntryResponses.getId());
    }

    public static Response get(String jsonName){
        return get(jsonName, TimeEntryResponse.class, setParamsGet());
    }

    private static Map<String, String> setParamsGet(){
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key", X_API_KEY.get());
        params.put("id-workspace", WORKSPACE_ID_0.get());
        params.put("id-timeEntry", TIME_ENTRY_ID.get());
        return params;
    }

    public static Response put(String jsonName){
        return put(jsonName, TimeEntryResponse.class, setParamsPut());
    }
    private static Map<String, String> setParamsPut(){
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key", X_API_KEY.get());
        params.put("id-workspace", WORKSPACE_ID_0.get());
        params.put("id-timeEntry", TIME_ENTRY_ID.get());
        params.put("description", DESCRIPTION.get());
        return params;
    }

    public static Response delete(String jsonName){
        return delete(jsonName, TimeEntryResponse.class, setParamsGet());
    }
}
