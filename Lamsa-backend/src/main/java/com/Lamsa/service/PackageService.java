package com.Lamsa.service;

import com.Lamsa.entity.Package;
import com.Lamsa.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    // Add package
    public Package addPackage(Package p) {
        return packageRepository.save(p);
    }

    // Get all packages
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }
}