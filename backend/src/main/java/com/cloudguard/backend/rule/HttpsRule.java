package com.cloudguard.backend.rule;
import com.cloudguard.backend.model.Severity;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;

public class HttpsRule implements SecurityRule {

    @Override
    public boolean check(CloudResource resource) {
        return !resource.usesHttps();
    }

    @Override
    public SecurityFinding getFinding() {
        return new SecurityFinding(
                "Resource is not using HTTPS",
                Severity.HIGH,
                "Enable HTTPS for secure communication"
        );
    }
}