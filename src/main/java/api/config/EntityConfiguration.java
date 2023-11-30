package api.config;

import services.TimeEntryService;
import services.WorkspaceService;

public enum EntityConfiguration {
    WORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return WorkspaceService.class;
        }
    },
    TIME_ENTRY {
        @Override
        public Class<?> getEntityService() {
            return TimeEntryService.class;
        }
    };


    public abstract Class<?> getEntityService();
}



