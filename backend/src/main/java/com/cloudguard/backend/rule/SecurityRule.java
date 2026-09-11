package com.cloudguard.backend.rule;

import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;

public interface SecurityRule {

    boolean check(CloudResource resource);

    SecurityFinding getFinding();
}