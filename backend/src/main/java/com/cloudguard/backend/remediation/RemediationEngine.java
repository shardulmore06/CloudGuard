package com.cloudguard.backend.remediation;

import com.cloudguard.backend.model.SecurityFinding;

public class RemediationEngine {

    public String getRemediation(SecurityFinding finding) {

        if (finding.getProblem().contains("Publicly accessible")) {
            return "Make the resource private";
        }

        if (finding.getProblem().contains("not using HTTPS")) {
            return "Enable HTTPS for secure communication";
        }

        return "Review the security finding and apply the recommended fix";
    }
}