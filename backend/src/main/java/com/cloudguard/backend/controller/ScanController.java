package com.cloudguard.backend.controller;

import com.cloudguard.backend.model.ScanRequest;
import com.cloudguard.backend.model.ScanResult;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.scanner.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanController {

    @GetMapping("/scan")
    public ScanResult scan(@RequestParam String name,
                           @RequestParam boolean isPublic,
                           @RequestParam boolean usesHttps,
                           @RequestParam boolean loggingEnabled) {

        CloudResource resource = new CloudResource(
                name,
                isPublic,
                usesHttps,
                loggingEnabled
        );

        Scanner scanner = new Scanner();

        return scanner.scan(resource);
    }

    @PostMapping("/scan")
    public ScanResult scanPost(@RequestBody ScanRequest request) {

        CloudResource resource = new CloudResource(
                request.getName(),
                request.isPublic(),
                request.isUsesHttps(),
                request.isLoggingEnabled()
        );

        Scanner scanner = new Scanner();

        return scanner.scan(resource);
    }
}