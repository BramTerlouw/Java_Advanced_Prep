package nl.inholland.tentamen.controller;

import nl.inholland.tentamen.model.dto.ProductDTO;
import nl.inholland.tentamen.model.dto.ProductResponseDTO;
import nl.inholland.tentamen.model.entity.Product;
import nl.inholland.tentamen.model.exception.ProductNotFoundException;
import nl.inholland.tentamen.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    private final ModelMapper mapper;

    public ProductController() {
        this.mapper = new ModelMapper();
    }

    @GetMapping()
    public List<ProductResponseDTO> getAll() {
        try {
            return productService.getAll().stream().map(product -> this.mapper.map(product, ProductResponseDTO.class)).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getOne(@PathVariable("id") String id) throws ProductNotFoundException {
        return this.mapper.map(productService.getOne(Long.valueOf(id)), ProductResponseDTO.class);
    }

    @PostMapping
    public ProductResponseDTO addOne(@Validated @RequestBody ProductDTO product) {
        return mapper.map(productService.addOne(mapper.map(product, Product.class)), ProductResponseDTO.class);
    }

    @PutMapping
    public ProductResponseDTO updateOne(@RequestBody ProductDTO product) {
        try {
            return mapper.map(productService.updateOne(mapper.map(product, Product.class)), ProductResponseDTO.class);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
        }
    }
}
