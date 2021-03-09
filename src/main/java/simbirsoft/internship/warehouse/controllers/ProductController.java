package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.ProductDto;
import simbirsoft.internship.warehouse.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Api(value = "product resources")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ApiOperation(value = "show all products", response = List.class)
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "find product by id", response = ProductDto.class)
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "create product", response = ProductDto.class)
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(productService.save(productDto));
    }

    @DeleteMapping
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

    @PutMapping
    @ApiOperation(value = "update the product", response = ProductDto.class)
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(productService.update(productDto));
    }
}
