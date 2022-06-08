package nl.inholland.tentamen.service;

import nl.inholland.tentamen.model.entity.Product;
import nl.inholland.tentamen.model.exception.ProductNotFoundException;
import nl.inholland.tentamen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product updateOne(Product product) {
        return productRepository.save(product);
    }

    public Product addOne(Product product) {
        return productRepository.save(product);
    }

    public void addOneFromSeeder(Product product) {
        productRepository.save(product);
    }
}
