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
import simbirsoft.internship.warehouse.dto.StoreDto;
import simbirsoft.internship.warehouse.entities.Store;
import simbirsoft.internship.warehouse.services.StoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "store resources")
public class StoreController {
    private final StoreService storeService;

    private final ModelMapper modelMapper;

    @GetMapping("/stores")
    @ApiOperation(value = "show all stores", response = List.class)
    public List<StoreDto> findAll() {
        return modelMapper.map(
                storeService.findAll(),
                new TypeToken<List<StoreDto>>() {
                }.getType()
        );
    }

    @GetMapping("/stores/{id}")
    @ApiOperation(value = "find store by id", response = StoreDto.class)
    public StoreDto findById(@PathVariable Long id) {
        return modelMapper.map(storeService.findById(id), StoreDto.class);
    }

    @GetMapping("/stores/{name}")
    @ApiOperation(value = "find store by name", response = StoreDto.class)
    public StoreDto findByName(@PathVariable String name) {
        return modelMapper.map(storeService.findByName(name), StoreDto.class);
    }

    @PostMapping("/stores")
    @ApiOperation(value = "create store", response = StoreDto.class)
    public StoreDto save(@RequestBody StoreDto storeDto) {
        Store store = storeService.save(modelMapper.map(storeDto, Store.class));
        return modelMapper.map(store, StoreDto.class);
    }

    @DeleteMapping("/stores")
    @ApiOperation(value = "delete store by id", response = ResponseEntity.class)
    public ResponseEntity<String> deleteById(@RequestParam(name = "storeId") Long storeId) {
        if (!storeService.deleteById(storeId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    String.format("Store with id %s is not found, or you cannot delete a store " +
                            "while it is attached to a warehouse", storeId)
            );
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/stores")
    @ApiOperation(value = "update store", response = StoreDto.class)
    public StoreDto update(@RequestBody StoreDto storeDto) {
        Store store = storeService.update(modelMapper.map(storeDto, Store.class));
        return modelMapper.map(store, StoreDto.class);
    }
}
