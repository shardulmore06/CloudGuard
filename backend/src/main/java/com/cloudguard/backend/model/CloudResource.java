package com.cloudguard.backend.model;

public class CloudResource {

    private String name;
    private boolean isPublic;
    private boolean usesHttps;

    public CloudResource(String name, boolean isPublic, boolean usesHttps) {
        this.name = name;
        this.isPublic = isPublic;
        this.usesHttps = usesHttps;
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
}