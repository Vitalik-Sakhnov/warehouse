package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Api(value = "order resources")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ApiOperation(value = "show all orders", response = List.class)
    public ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "find order by id", response = OrderDto.class)
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "create order", response = OrderDto.class)
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().body(orderService.save(orderDto));
    }
}
