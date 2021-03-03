package simbirsoft.internship.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.StoreDto;
import simbirsoft.internship.warehouse.entities.Store;
import simbirsoft.internship.warehouse.services.impl.StoreServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreServiceImpl storeService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<StoreDto> findAll() {
        return modelMapper.map(
                storeService.findAll(),
                new TypeToken<List<StoreDto>>() {
                }.getType()
        );
    }

    @GetMapping("/id")
    public StoreDto findById(@RequestParam(name = "storeId") Long storeId) {
        return modelMapper.map(storeService.findById(storeId), StoreDto.class);
    }

    @GetMapping("/name")
    public StoreDto findByName(@RequestParam(name = "storeName") String storeName) {
        return modelMapper.map(storeService.findByName(storeName), StoreDto.class);
    }

    @PostMapping("/new")
    public StoreDto save(@RequestBody StoreDto storeDto) {
        Store store = storeService.save(modelMapper.map(storeDto, Store.class));
        return modelMapper.map(store, StoreDto.class);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam(name = "storeId") Long storeId) {
        if (!storeService.deleteById(storeId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    String.format("Store with id %s is not found, or you cannot delete a store " +
                            "while it is attached to a warehouse", storeId)
            );
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public StoreDto update(@RequestBody StoreDto storeDto) {
        Store store = storeService.update(modelMapper.map(storeDto, Store.class));
        return modelMapper.map(store, StoreDto.class);
    }
}
