package com.Lamsa.controller;

import com.Lamsa.entity.Package;
import com.Lamsa.service.PackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    // Add package
    @PostMapping
    public Package createPackage(@RequestBody Package p) {
        return packageService.addPackage(p);
    }

    // Get all packages
    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }
}
