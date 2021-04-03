package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.WriteOffDto;
import simbirsoft.internship.warehouse.services.WriteOffService;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/writeOffs")
@Api(value = "writeOff resources")
public class WriteOffController {
    private final WriteOffService writeOffService;

    @GetMapping
    @ApiOperation(value = "show all writeOffs", response = List.class)
    public ResponseEntity<List<WriteOffDto>> findAll() {
        return ResponseEntity.ok().body(writeOffService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('writeOff:write')")
    @ApiOperation(value = "create writeOff", response = WriteOffDto.class)
    public ResponseEntity<String> save(@RequestBody WriteOffDto writeOffDto) {
        if (writeOffService.save(writeOffDto) == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                    String.format("The quantity of the product to be written off exceeds" +
                            " the quantity of the product in warehouse", writeOffDto.getGoodsQuantity()));
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/period")
    public ResponseEntity<List<WriteOffDto>> period(@RequestParam(name = "firstDate") Date firstDate,
                                                    @RequestParam(name = "secondDate") Date secondDate) {
        return ResponseEntity.ok().body(writeOffService.byPeriod(firstDate, secondDate));
    }
}
