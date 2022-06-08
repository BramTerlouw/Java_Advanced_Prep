package nl.inholland.tentamen.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String description;
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "brand_Id")
    private Brand brand;
}