package com.cloudguard.backend.rule;

import java.util.ArrayList;
import java.util.List;

public class RuleManager {

    private List<SecurityRule> rules = new ArrayList<>();

    public RuleManager() {
        rules.add(new PublicAccessRule());
        rules.add(new HttpsRule());
        rules.add(new LoggingRule());
    }

    public List<SecurityRule> getRules() {
        return rules;
    }
}