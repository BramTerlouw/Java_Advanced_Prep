package nl.inholland.tentamen.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "customers_brands",
            joinColumns = @JoinColumn(name = "customer_Id"),
            inverseJoinColumns = @JoinColumn(name = "brand_Id"))
    private List<Brand> brands = new ArrayList<>();
}
