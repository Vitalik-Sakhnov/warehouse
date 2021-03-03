package simbirsoft.internship.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.ConsumptionDto;
import simbirsoft.internship.warehouse.entities.Consumption;
import simbirsoft.internship.warehouse.services.impl.ConsumptionServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumption")
public class ConsumptionController {
    private final ConsumptionServiceImpl consumptionService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<ConsumptionDto> findAll() {
        return modelMapper.map(
                consumptionService.findAll(),
                new TypeToken<List<ConsumptionDto>>() {
                }.getType()
        );
    }

    @PostMapping("/new")
    public ConsumptionDto save(@RequestBody ConsumptionDto consumptionDto) {
        Consumption consumption = consumptionService.save(modelMapper.map(consumptionDto, Consumption.class));
        return modelMapper.map(consumption, ConsumptionDto.class);
    }
}
