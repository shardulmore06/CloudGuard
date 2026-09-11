package com.cloudguard.backend.remediation;

import com.cloudguard.backend.model.SecurityFinding;

public class RemediationEngine {

    public String getRemediation(SecurityFinding finding) {

        return finding.getSolution();
    }
}