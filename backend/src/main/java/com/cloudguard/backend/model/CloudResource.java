package com.cloudguard.backend.model;

public class CloudResource {

    private String name;
    private boolean isPublic;
    private boolean usesHttps;
    private boolean loggingEnabled;

    public CloudResource(String name, boolean isPublic, boolean usesHttps, boolean loggingEnabled) {
        this.name = name;
        this.isPublic = isPublic;
        this.usesHttps = usesHttps;
        this.loggingEnabled = loggingEnabled;
    }

    public String getName() {
        return name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean usesHttps() {
        return usesHttps;
    }

    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }
}