package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.SupplyDto;
import simbirsoft.internship.warehouse.services.SupplyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplies")
@Api(value = "supply resources")
public class SupplyController {
    private final SupplyService supplyService;

    @GetMapping
    @ApiOperation(value = "show all supply", response = List.class)
    public ResponseEntity<List<SupplyDto>> findAll() {
        return ResponseEntity.ok().body(supplyService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('supply:write')")
    @ApiOperation(value = "create supply", response = SupplyDto.class)
    public ResponseEntity<SupplyDto> save(@RequestBody SupplyDto supplyDto) {
        return ResponseEntity.ok().body(supplyService.save(supplyDto));
    }
}
