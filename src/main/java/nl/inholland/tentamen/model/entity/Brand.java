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
public class Brand {

    @Id
    @GeneratedValue
    private Long brandId;
    private String name;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_Id")
    private Set<Product> products = new HashSet<>();

    @ManyToMany(mappedBy = "brands")
    private Set<Customer> customers = new HashSet<>();
}
