package com.cloudguard.backend.model;

public class SecurityFinding {

    private String problem;
    private Severity severity;
    private String solution;

    public SecurityFinding(String problem, Severity severity, String solution) {
        this.problem = problem;
        this.severity = severity;
        this.solution = solution;
    }

    public String getProblem() {
        return problem;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getSolution() {
        return solution;
    }
}