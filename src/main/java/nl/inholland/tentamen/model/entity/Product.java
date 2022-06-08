package nl.inholland.tentamen.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Description must not be empty")
    private String description;

    @NotNull(message = "Price must not be empty")
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "brand_Id")
    private Brand brand;
}
