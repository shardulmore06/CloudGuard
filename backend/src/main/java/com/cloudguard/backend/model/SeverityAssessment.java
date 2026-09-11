package com.cloudguard.backend.model;

import java.util.List;

public class SeverityAssessment {

    public static Severity getOverallSeverity(List<SecurityFinding> findings) {

        Severity overallSeverity = Severity.LOW;

        for (SecurityFinding finding : findings) {

            if (finding.getSeverity() == Severity.CRITICAL) {
                return Severity.CRITICAL;
            }

            if (finding.getSeverity() == Severity.HIGH) {
                overallSeverity = Severity.HIGH;
            }

            else if (finding.getSeverity() == Severity.MEDIUM
                    && overallSeverity == Severity.LOW) {
                overallSeverity = Severity.MEDIUM;
            }
        }

        return overallSeverity;
    }
}