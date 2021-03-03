package simbirsoft.internship.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.ProductDto;
import simbirsoft.internship.warehouse.entities.Product;
import simbirsoft.internship.warehouse.services.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<ProductDto> findAll() {
        return modelMapper.map(
                productService.findAll(),
                new TypeToken<List<ProductDto>>() {
                }.getType()
        );
    }

    @GetMapping("/id")
    public ProductDto findById(@RequestParam(name = "productId") Long productId) {
        return modelMapper.map(productService.findById(productId), ProductDto.class);
    }

    @PostMapping("/new")
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = productService.save(modelMapper.map(productDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam(name = "storeId") Long productId) {
        if (!productService.deleteById(productId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    String.format("Product with id %s is not found, or you cannot delete a product " +
                            "while it it has a group", productId)
            );
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ProductDto update(@RequestBody ProductDto storeDto) {
        Product product = productService.update(modelMapper.map(storeDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }
}
