package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.WriteOffDto;
import simbirsoft.internship.warehouse.entities.WriteOff;
import simbirsoft.internship.warehouse.services.impl.WriteOffServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/writeOff")
@Api(value = "writeOff resources")
public class WriteOffController {
    private final WriteOffServiceImpl writeOffService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    @ApiOperation(value = "show all writeOffs", response = List.class)
    public List<WriteOffDto> findAll() {
        return modelMapper.map(
                writeOffService.findAll(),
                new TypeToken<List<WriteOffDto>>() {
                }.getType()
        );
    }

    @PostMapping("/new")
    @ApiOperation(value = "create writeOff", response = WriteOffDto.class)
    public WriteOffDto save(@RequestBody WriteOffDto writeOffDto) {
        WriteOff writeOff = writeOffService.save(modelMapper.map(writeOffDto, WriteOff.class));
        return modelMapper.map(writeOff, WriteOffDto.class);
    }
}
