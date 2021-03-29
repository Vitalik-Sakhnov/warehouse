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
import simbirsoft.internship.warehouse.dto.StoreDto;
import simbirsoft.internship.warehouse.services.StoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Api(value = "store resources")
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    @ApiOperation(value = "show all stores", response = List.class)
    public ResponseEntity<List<StoreDto>> findAll() {
        return ResponseEntity.ok().body(storeService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('store:read')")
    @ApiOperation(value = "find store by id", response = StoreDto.class)
    public ResponseEntity<StoreDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(storeService.findById(id));
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyAuthority('store:read')")
    @ApiOperation(value = "find store by name", response = StoreDto.class)
    public ResponseEntity<StoreDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(storeService.findByName(name));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('store:write')")
    @ApiOperation(value = "create store", response = StoreDto.class)
    public ResponseEntity<StoreDto> save(@RequestBody StoreDto storeDto) {
        return ResponseEntity.ok().body(storeService.save(storeDto));
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('store:write')")
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

    @PutMapping
    @PreAuthorize("hasAnyAuthority('store:write')")
    @ApiOperation(value = "update store", response = StoreDto.class)
    public ResponseEntity<StoreDto> update(@RequestBody StoreDto storeDto) {
        return ResponseEntity.ok().body(storeService.update(storeDto));
    }
}
