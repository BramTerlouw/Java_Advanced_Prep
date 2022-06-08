package nl.inholland.tentamen.service;

import nl.inholland.tentamen.model.entity.Brand;
import nl.inholland.tentamen.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public void addBrandFromSeeder(Brand brand) {
        brandRepository.save(brand);
    }

    public void updateBrandId() {
        brandRepository.updateId();
    }
}
