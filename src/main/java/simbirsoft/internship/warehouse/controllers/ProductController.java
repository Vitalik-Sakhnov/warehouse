package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.ProductDto;
import simbirsoft.internship.warehouse.entities.Product;
import simbirsoft.internship.warehouse.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "product resources")
public class ProductController {
    private final ProductService productService;

    private final ModelMapper modelMapper;

    @GetMapping("/products")
    @ApiOperation(value = "show all products", response = List.class)
    public List<ProductDto> findAll() {
        return modelMapper.map(
                productService.findAll(),
                new TypeToken<List<ProductDto>>() {
                }.getType()
        );
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "find product by id", response = ProductDto.class)
    public ProductDto findById(@PathVariable Long id) {
        return modelMapper.map(productService.findById(id), ProductDto.class);
    }

    @PostMapping("/products")
    @ApiOperation(value = "create product", response = ProductDto.class)
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = productService.save(modelMapper.map(productDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }

    @DeleteMapping("/products")
    @ApiOperation(value = "delete product by id", response = ResponseEntity.class)
    public ResponseEntity<String> deleteById(@RequestParam(name = "storeId") Long productId) {
        if (!productService.deleteById(productId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    String.format("Product with id %s is not found, or you cannot delete a product " +
                            "while it it has a group", productId)
            );
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products")
    @ApiOperation(value = "update the product", response = ProductDto.class)
    public ProductDto update(@RequestBody ProductDto storeDto) {
        Product product = productService.update(modelMapper.map(storeDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }
}
