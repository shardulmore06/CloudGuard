
package com.cloudguard.backend.controller;

import com.cloudguard.backend.model.CloudResource;
import com.cloudguard.backend.model.ScanResult;
import com.cloudguard.backend.scanner.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ConfigUploadController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/scan/upload")
    public List<ResourceScan> scanUpload(
            @RequestPart("file") MultipartFile file) {

        if (file.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please upload a JSON file");
        }

        if (file.getSize() > 1024 * 1024) {
            throw new ResponseStatusException(
                    HttpStatus.CONTENT_TOO_LARGE,
                    "File must be 1 MB or smaller");
        }

        try {
            JsonNode root = objectMapper.readTree(file.getInputStream());
            JsonNode resources = root.isArray()
                    ? root : root.path("resources");

            if (!resources.isArray() || resources.isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "JSON must contain a non-empty resources array");
            }

            if (resources.size() > 100) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Maximum 100 resources per upload");
            }

            List<ResourceScan> results = new ArrayList<>();
            Scanner scanner = new Scanner();

            for (JsonNode item : resources) {
                if (!item.hasNonNull("name")
                        || !item.has("isPublic")
                        || !item.has("usesHttps")
                        || !item.has("loggingEnabled")
                        || !item.get("isPublic").isBoolean()
                        || !item.get("usesHttps").isBoolean()
                        || !item.get("loggingEnabled").isBoolean()) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Each resource needs name, isPublic, usesHttps, and loggingEnabled; the three settings must be true or false");
                }

                String name = item.get("name").asText().trim();

                if (name.isEmpty()) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Resource name cannot be empty");
                }

                CloudResource resource = new CloudResource(
                        name,
                        item.get("isPublic").asBoolean(),
                        item.get("usesHttps").asBoolean(),
                        item.get("loggingEnabled").asBoolean()
                );

                results.add(new ResourceScan(name, scanner.scan(resource)));
            }

            return results;

        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid JSON file");
        }
    }

    public static class ResourceScan {
        private final String resourceName;
        private final ScanResult result;

        public ResourceScan(String resourceName, ScanResult result) {
            this.resourceName = resourceName;
            this.result = result;
        }

        public String getResourceName() {
            return resourceName;
        }

        public ScanResult getResult() {
            return result;
        }
    }
}
