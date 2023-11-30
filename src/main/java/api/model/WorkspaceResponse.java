package api.model;
import api.model.workspaces.WorkspaceSettings;
import api.model.workspaces.HourlyRate;
import api.model.workspaces.Membership;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkspaceResponse {
    private String id;
    private String name;
    private HourlyRate hourlyRate;
    private List<Membership> memberships;
    private WorkspaceSettings workspaceSettings;
    private String imageUrl;
    private String featureSubscriptionType;

}
