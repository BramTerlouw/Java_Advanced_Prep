package nl.inholland.tentamen.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "customers_brands",
            joinColumns = @JoinColumn(name = "customer_Id"),
            inverseJoinColumns = @JoinColumn(name = "brand_Id"))
    private Set<Brand> brands = new HashSet<>();

}
