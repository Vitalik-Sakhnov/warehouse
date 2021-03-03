package simbirsoft.internship.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.ProductGroupDto;
import simbirsoft.internship.warehouse.entities.ProductGroup;
import simbirsoft.internship.warehouse.services.impl.ProductGroupServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class ProductGroupController {
    private final ProductGroupServiceImpl productGroupService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<ProductGroupDto> findAll() {
        return modelMapper.map(
                productGroupService.findAll(),
                new TypeToken<List<ProductGroupDto>>() {
                }.getType()
        );
    }

    @GetMapping("/id")
    public ProductGroupDto findById(@RequestParam(name = "groupId") Long groupId) {
        return modelMapper.map(productGroupService.findById(groupId), ProductGroupDto.class);
    }

    @GetMapping("/name")
    public ProductGroupDto findByName(@RequestParam(name = "groupName") String groupName) {
        return modelMapper.map(productGroupService.findByName(groupName), ProductGroupDto.class);
    }

    @PostMapping("/new")
    public ProductGroupDto save(@RequestBody ProductGroupDto groupDto) {
        ProductGroup group = productGroupService.save(modelMapper.map(groupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }

    @DeleteMapping
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
    public ProductGroupDto update(@RequestBody ProductGroupDto groupDto) {
        ProductGroup group = productGroupService.update(modelMapper.map(groupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }
}
