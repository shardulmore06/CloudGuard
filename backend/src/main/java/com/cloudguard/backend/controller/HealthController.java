package com.cloudguard.backend.controller;

import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.SecurityFinding;
import com.cloudguard.backend.scanner.Scanner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "CloudGuard is running!";
    }

    @GetMapping("/api/scan")
    public List<SecurityFinding> scanResource() {

        CloudResource resource = new CloudResource(
        "Test Cloud Resource",
        false,
        true
);
        Scanner scanner = new Scanner();

        return scanner.scan(resource);
    }
}