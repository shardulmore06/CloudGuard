package com.cloudguard.backend.scanner;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;
import com.cloudguard.backend.model.Severity;
import com.cloudguard.backend.rule.HttpsRule;
import com.cloudguard.backend.rule.PublicAccessRule;
import com.cloudguard.backend.rule.SecurityRule;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private List<SecurityRule> rules = new ArrayList<>();

    public Scanner() {
    rules.add(new PublicAccessRule());
    rules.add(new HttpsRule());
}
    public List<SecurityFinding> scan(CloudResource resource) {

        List<SecurityFinding> findings = new ArrayList<>();

        for (SecurityRule rule : rules) {

            if (rule.check(resource)) {

                findings.add(rule.getFinding());
            }
        }

        if (findings.isEmpty()) {
            findings.add(new SecurityFinding(
                    "No security issues found",
                    Severity.LOW,
                    "No action required"
            ));
        }

        return findings;
    }
}