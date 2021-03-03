package simbirsoft.internship.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.WarehouseDto;
import simbirsoft.internship.warehouse.entities.Warehouse;
import simbirsoft.internship.warehouse.services.impl.WarehouseServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseServiceImpl warehouseService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<WarehouseDto> findAll() {
        return modelMapper.map(
                warehouseService.findAll(),
                new TypeToken<List<WarehouseDto>>() {
                }.getType()
        );
    }

    @PostMapping("/new")
    public WarehouseDto save(@RequestBody WarehouseDto warehouseDto) {
        Warehouse warehouse = warehouseService.save(modelMapper.map(warehouseDto, Warehouse.class));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }
}
