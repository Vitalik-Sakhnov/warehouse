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
import simbirsoft.internship.warehouse.dto.ConsumptionDto;
import simbirsoft.internship.warehouse.services.ConsumptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumptions")
@Api(value = "consumption resources")
public class ConsumptionController {
    private final ConsumptionService consumptionService;

    @GetMapping
    @ApiOperation(value = "show all consumptions", response = List.class)
    public ResponseEntity<List<ConsumptionDto>> findAll() {
        return ResponseEntity.ok().body(consumptionService.findAll());
    }

    @PostMapping
    @ApiOperation(value = "create consumption", response = ConsumptionDto.class)
    public ResponseEntity<ConsumptionDto> save(@RequestBody ConsumptionDto consumptionDto) {
        return ResponseEntity.ok().body(consumptionService.save(consumptionDto));
    }
}
