package com.cloudguard.backend.rule;
import com.cloudguard.backend.model.Severity;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;

public class PublicAccessRule implements SecurityRule {

    @Override
    public boolean check(CloudResource resource) {
        return resource.isPublic();
    }

    @Override
    public SecurityFinding getFinding() {
        return new SecurityFinding(
                "Publicly accessible cloud resource",
                Severity.HIGH,
                "Make the resource private"
        );
    }
}