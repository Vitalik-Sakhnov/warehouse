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
import simbirsoft.internship.warehouse.dto.ProductGroupDto;
import simbirsoft.internship.warehouse.entities.ProductGroup;
import simbirsoft.internship.warehouse.services.ProductGroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "product group resources")
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    private final ModelMapper modelMapper;

    @GetMapping("/groups")
    @ApiOperation(value = "show all product groups", response = List.class)
    public List<ProductGroupDto> findAll() {
        return modelMapper.map(
                productGroupService.findAll(),
                new TypeToken<List<ProductGroupDto>>() {
                }.getType()
        );
    }

    @GetMapping("/groups/{id}")
    @ApiOperation(value = "find product group by id", response = ProductGroupDto.class)
    public ProductGroupDto findById(@PathVariable Long id) {
        return modelMapper.map(productGroupService.findById(id), ProductGroupDto.class);
    }

    @GetMapping("/groups/{name}")
    @ApiOperation(value = "find product group by name", response = ProductGroupDto.class)
    public ProductGroupDto findByName(@PathVariable String name) {
        return modelMapper.map(productGroupService.findByName(name), ProductGroupDto.class);
    }

    @PostMapping("/groups")
    @ApiOperation(value = "create product group", response = ProductGroupDto.class)
    public ProductGroupDto save(@RequestBody ProductGroupDto groupDto) {
        ProductGroup group = productGroupService.save(modelMapper.map(groupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }

    @DeleteMapping("/groups")
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

    @PostMapping("/groups")
    @ApiOperation(value = "update the product group", response = ProductGroupDto.class)
    public ProductGroupDto update(@RequestBody ProductGroupDto groupDto) {
        ProductGroup group = productGroupService.update(modelMapper.map(groupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }
}
