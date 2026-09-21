package com.cloudguard.backend.remediation;

import com.cloudguard.backend.model.FindingType;
import com.cloudguard.backend.model.SecurityFinding;

public class RemediationEngine {

    public String getRemediation(SecurityFinding finding) {

        if (finding == null) {
            return "No security finding provided";
        }

        if (finding.getType() == FindingType.PUBLIC_ACCESS) {
            return "Make the resource private";
        }

        if (finding.getType() == FindingType.HTTPS) {
            return "Enable HTTPS for secure communication";
        }

        if (finding.getType() == FindingType.LOGGING) {
            return "Enable logging for the cloud resource";
        }

        return "Review the security finding and apply the recommended fix";
    }
}