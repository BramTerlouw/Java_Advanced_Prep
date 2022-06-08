package nl.inholland.tentamen.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();

    @ManyToMany(mappedBy = "brands", cascade = CascadeType.PERSIST)
    private List<Customer> customers = new ArrayList<>();

    public void addProductToBrand(Product product) {
        product.setBrand(this);
        this.products.add(product);
    }

    public void addCustomerToBrand(Customer customer) {
        customer.setBrands(List.of(this));
        this.customers.add(customer);
    }
}
