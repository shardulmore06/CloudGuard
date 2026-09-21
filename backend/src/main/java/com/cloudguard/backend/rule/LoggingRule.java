package com.cloudguard.backend.rule;
import com.cloudguard.backend.model.FindingType;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;
import com.cloudguard.backend.model.Severity;

public class LoggingRule implements SecurityRule {

    @Override
    public boolean check(CloudResource resource) {
        return !resource.isLoggingEnabled();
    }

    @Override
public SecurityFinding getFinding() {
    return new SecurityFinding(
            "Cloud resource logging is disabled",
            Severity.MEDIUM,
            FindingType.LOGGING
    );
}
}