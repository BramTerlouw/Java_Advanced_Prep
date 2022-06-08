package nl.inholland.tentamen.configuration;

import nl.inholland.tentamen.model.entity.Brand;
import nl.inholland.tentamen.model.entity.Customer;
import nl.inholland.tentamen.model.entity.Product;
import nl.inholland.tentamen.service.BrandService;
import nl.inholland.tentamen.service.CustomerService;
import nl.inholland.tentamen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CustomerService customerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Product productOne = new Product();
        productOne.setDescription("Life, 'uh', find a way...");
        productOne.setName("Dinosaur toy");
        productOne.setPrice(10.0);

        Brand brandOne = new Brand();
        brandOne.setName("Jurassic park");

        Customer customerOne = new Customer();
        customerOne.setName("Mark Haan");

        brandOne.addCustomerToBrand(customerOne);
        brandOne.addProductToBrand(productOne);

        brandService.addBrandFromSeeder(brandOne);
        productService.addOneFromSeeder(productOne);
        customerService.addCustomerFromSeeder(customerOne);

        // brandService.updateBrandId();
    }
}
