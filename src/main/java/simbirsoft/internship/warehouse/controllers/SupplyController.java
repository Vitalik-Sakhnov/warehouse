package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.SupplyDto;
import simbirsoft.internship.warehouse.entities.Supply;
import simbirsoft.internship.warehouse.services.impl.SupplyServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supply")
@Api(value = "supply resources")
public class SupplyController {
    private final SupplyServiceImpl supplyService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    @ApiOperation(value = "show all supply", response = List.class)
    public List<SupplyDto> findAll() {
        return modelMapper.map(
                supplyService.findAll(),
                new TypeToken<List<SupplyDto>>() {
                }.getType()
        );
    }

    @PostMapping("/new")
    @ApiOperation(value = "create supply", response = SupplyDto.class)
    public SupplyDto save(@RequestBody SupplyDto supplyDto) {
        Supply supply = supplyService.save(modelMapper.map(supplyDto, Supply.class));
        return modelMapper.map(supply, SupplyDto.class);
    }
}
