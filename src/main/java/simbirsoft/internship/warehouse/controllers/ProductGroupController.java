package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.ProductGroupDto;
import simbirsoft.internship.warehouse.services.ProductGroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
@Api(value = "product group resources")
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    @GetMapping
    @ApiOperation(value = "show all product groups", response = List.class)
    public ResponseEntity<List<ProductGroupDto>> findAll() {
        return ResponseEntity.ok().body(productGroupService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('productGroup:read')")
    @ApiOperation(value = "find product group by id", response = ProductGroupDto.class)
    public ResponseEntity<ProductGroupDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productGroupService.findById(id));
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyAuthority('productGroup:read')")
    @ApiOperation(value = "find product group by name", response = ProductGroupDto.class)
    public ResponseEntity<ProductGroupDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(productGroupService.findByName(name));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('productGroup:write')")
    @ApiOperation(value = "create product group", response = ProductGroupDto.class)
    public ResponseEntity<ProductGroupDto> save(@RequestBody ProductGroupDto groupDto) {
        return ResponseEntity.ok().body(productGroupService.save(groupDto));
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('productGroup:write')")
    @ApiOperation(value = "delete product group by id", response = ResponseEntity.class)
    public ResponseEntity<String> deleteById(@RequestParam(name = "groupId") Long groupId) {
        if (!productGroupService.deleteById(groupId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    String.format("Product group with id %s is not found, or you cannot delete a group " +
                            "while it is attached to the product", groupId)
            );
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('productGroup:write')")
    @ApiOperation(value = "update the product group", response = ProductGroupDto.class)
    public ResponseEntity<ProductGroupDto> update(@RequestBody ProductGroupDto groupDto) {
        return ResponseEntity.ok().body(productGroupService.update(groupDto));
    }
}
