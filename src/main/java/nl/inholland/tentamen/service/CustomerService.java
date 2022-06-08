package nl.inholland.tentamen.service;

import nl.inholland.tentamen.model.entity.Customer;
import nl.inholland.tentamen.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomerFromSeeder(Customer customer) {
        customerRepository.save(customer);
    }
}
