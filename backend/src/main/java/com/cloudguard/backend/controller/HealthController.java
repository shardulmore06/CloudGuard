package com.cloudguard.backend.controller;

import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.ScanResult;
import com.cloudguard.backend.scanner.Scanner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "CloudGuard is running!";
    }

    @GetMapping("/api/scan")
    public ScanResult scanResource() {

        CloudResource resource = new CloudResource(
                "Test Cloud Resource",
                false,
                true,
                true
        );

        Scanner scanner = new Scanner();

        return scanner.scan(resource);
    }
}