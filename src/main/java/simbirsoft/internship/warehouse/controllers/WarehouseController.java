package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.WarehouseDto;
import simbirsoft.internship.warehouse.services.WarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouses")
@Api(value = "warehouse resources")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping
    @ApiOperation(value = "show all warehouses", response = List.class)
    public ResponseEntity<List<WarehouseDto>> findAll() {
        return ResponseEntity.ok().body(warehouseService.findAll());
    }

    @PostMapping
    @ApiOperation(value = "create warehouse", response = WarehouseDto.class)
    public ResponseEntity<WarehouseDto> save(@RequestBody WarehouseDto warehouseDto) {
        return ResponseEntity.ok().body(warehouseService.save(warehouseDto));
    }
}
