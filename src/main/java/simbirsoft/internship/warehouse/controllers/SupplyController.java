package simbirsoft.internship.warehouse.controllers;

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
public class SupplyController {
    private final SupplyServiceImpl supplyService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<SupplyDto> findAll() {
        return modelMapper.map(
                supplyService.findAll(),
                new TypeToken<List<SupplyDto>>() {
                }.getType()
        );
    }

    @PostMapping("/new")
    public SupplyDto save(@RequestBody SupplyDto supplyDto) {
        Supply supply = supplyService.save(modelMapper.map(supplyDto, Supply.class));
        return modelMapper.map(supply, SupplyDto.class);
    }
}
