package com.cloudguard.backend.controller;
import com.cloudguard.backend.model.ScanResult;
import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.scanner.Scanner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ScanController {

    @GetMapping("/scan")
   public ScanResult scan(@RequestParam String name,
                       @RequestParam boolean isPublic,
                       @RequestParam boolean usesHttps) {

    CloudResource resource = new CloudResource(name, isPublic, usesHttps);

        Scanner scanner = new Scanner();

        return scanner.scan(resource);
    }
}