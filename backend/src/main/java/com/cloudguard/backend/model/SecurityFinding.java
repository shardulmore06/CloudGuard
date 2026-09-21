package com.cloudguard.backend.model;

public class SecurityFinding {

    private String problem;
    private Severity severity;
    private FindingType type;
    private String solution;

    public SecurityFinding(String problem, Severity severity, FindingType type) {
        this.problem = problem;
        this.severity = severity;
        this.type = type;
    }

    public String getProblem() {
        return problem;
    }

    public Severity getSeverity() {
        return severity;
    }

    public FindingType getType() {
        return type;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}