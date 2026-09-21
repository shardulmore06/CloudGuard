package com.cloudguard.backend.scanner;
import com.cloudguard.backend.model.ScanResult;
import com.cloudguard.backend.model.SeverityAssessment;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;
import com.cloudguard.backend.model.Severity;
import com.cloudguard.backend.remediation.RemediationEngine;
import com.cloudguard.backend.rule.SecurityRule;
import com.cloudguard.backend.rule.RuleManager;
import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private RuleManager ruleManager = new RuleManager();
    private RemediationEngine remediationEngine = new RemediationEngine();

    
    public ScanResult scan(CloudResource resource) {

        List<SecurityFinding> findings = new ArrayList<>();

        for (SecurityRule rule : ruleManager.getRules()) {

           if (rule.check(resource)) {

    SecurityFinding finding = rule.getFinding();

String remediation = remediationEngine.getRemediation(finding);

finding.setSolution(remediation);

findings.add(finding);
}
        }

       if (findings.isEmpty()) {

    SecurityFinding finding = new SecurityFinding(
            "No security issues found",
            Severity.LOW,
            null
    );

    finding.setSolution("No action required");

    findings.add(finding);
}
       Severity overallSeverity = SeverityAssessment.getOverallSeverity(findings);

return new ScanResult(findings, overallSeverity);
    }
}