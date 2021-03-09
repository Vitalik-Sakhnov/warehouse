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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.ProductGroupDto;
import simbirsoft.internship.warehouse.entities.ProductGroup;
import simbirsoft.internship.warehouse.services.impl.ProductGroupServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
@Api(value = "product group resources")
public class ProductGroupController {
    private final ProductGroupServiceImpl productGroupService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    @ApiOperation(value = "show all product groups", response = List.class)
    public List<ProductGroupDto> findAll() {
        return modelMapper.map(
                productGroupService.findAll(),
                new TypeToken<List<ProductGroupDto>>() {
                }.getType()
        );
    }

    @GetMapping("/id")
    @ApiOperation(value = "find product group by id", response = ProductGroupDto.class)
    public ProductGroupDto findById(@RequestParam(name = "groupId") Long groupId) {
        return modelMapper.map(productGroupService.findById(groupId), ProductGroupDto.class);
    }

    @GetMapping("/name")
    @ApiOperation(value = "find product group by name", response = ProductGroupDto.class)
    public ProductGroupDto findByName(@RequestParam(name = "groupName") String groupName) {
        return modelMapper.map(productGroupService.findByName(groupName), ProductGroupDto.class);
    }

    @PostMapping("/new")
    @ApiOperation(value = "create product group", response = ProductGroupDto.class)
    public ProductGroupDto save(@RequestBody ProductGroupDto groupDto) {
        ProductGroup group = productGroupService.save(modelMapper.map(groupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }

    @DeleteMapping
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

    @PostMapping
    @ApiOperation(value = "update the product group", response = ProductGroupDto.class)
    public ProductGroupDto update(@RequestBody ProductGroupDto groupDto) {
        ProductGroup group = productGroupService.update(modelMapper.map(groupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }
}
