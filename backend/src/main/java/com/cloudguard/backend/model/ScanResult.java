package com.cloudguard.backend.model;

import java.util.List;

public class ScanResult {

    private List<SecurityFinding> findings;
    private Severity overallSeverity;

    public ScanResult(List<SecurityFinding> findings, Severity overallSeverity) {
        this.findings = findings;
        this.overallSeverity = overallSeverity;
    }

    public List<SecurityFinding> getFindings() {
        return findings;
    }

    public Severity getOverallSeverity() {
        return overallSeverity;
    }
}