
package com.cloudguard.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScanRequest {

    private String name;
    private boolean publicResource;
    private boolean usesHttps;
    private boolean loggingEnabled;

    public String getName() {
        return name;
    }

    @JsonProperty("publicResource")
    public void setPublicResource(boolean publicResource) {
        this.publicResource = publicResource;
    }

    public boolean isPublic() {
        return publicResource;
    }

    public void setUsesHttps(boolean usesHttps) {
        this.usesHttps = usesHttps;
    }

    public boolean isUsesHttps() {
        return usesHttps;
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public void setName(String name) {
        this.name = name;
    }
}
