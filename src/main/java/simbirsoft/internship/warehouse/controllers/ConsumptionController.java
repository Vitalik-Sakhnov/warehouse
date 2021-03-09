package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.ConsumptionDto;
import simbirsoft.internship.warehouse.entities.Consumption;
import simbirsoft.internship.warehouse.services.ConsumptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "consumption resources")
public class ConsumptionController {
    private final ConsumptionService consumptionService;

    private final ModelMapper modelMapper;

    @GetMapping("/consumptions")
    @ApiOperation(value = "show all consumptions", response = List.class)
    public List<ConsumptionDto> findAll() {
        return modelMapper.map(
                consumptionService.findAll(),
                new TypeToken<List<ConsumptionDto>>() {
                }.getType()
        );
    }

    @PostMapping("/consumptions")
    @ApiOperation(value = "create consumption", response = ConsumptionDto.class)
    public ConsumptionDto save(@RequestBody ConsumptionDto consumptionDto) {
        Consumption consumption = consumptionService.save(modelMapper.map(consumptionDto, Consumption.class));
        return modelMapper.map(consumption, ConsumptionDto.class);
    }
}
