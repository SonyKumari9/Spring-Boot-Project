package ecommerce.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.VendorModel;
import ecommerce.example.ecommerce.repo.VendorRepository;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepo;

    public List<VendorModel> getAllVendors() {
        return vendorRepo.findAll();
    }

    public VendorModel saveVendor(VendorModel vendor) {
        return vendorRepo.save(vendor);
    }

    public VendorModel updateVendor(int id, VendorModel updated) {
        VendorModel existing = vendorRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Vendor not found"));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setActive(updated.isActive());
        return vendorRepo.save(existing);
    }

    public void deleteVendor(int id) {
        vendorRepo.deleteById(id);
    }
}

