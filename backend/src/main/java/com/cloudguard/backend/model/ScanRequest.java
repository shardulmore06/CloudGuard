package com.cloudguard.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScanRequest {

    private String name;

    @JsonProperty("isPublic")
    private boolean publicResource;

    private boolean usesHttps;
    private boolean loggingEnabled;

    public String getName() {
        return name;
    }

    public boolean isPublic() {
        return publicResource;
    }

    public boolean isUsesHttps() {
        return usesHttps;
    }

    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }
}