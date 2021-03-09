package simbirsoft.internship.warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "order resources")
public class OrderController {
    private final OrderService orderService;

    private final ModelMapper modelMapper;

    @GetMapping("/orders")
    @ApiOperation(value = "show all orders", response = List.class)
    public List<OrderDto> findAll() {
        return modelMapper.map(
                orderService.findAll(),
                new TypeToken<List<OrderDto>>() {
                }.getType()
        );
    }

    @GetMapping("/orders/{id}")
    @ApiOperation(value = "find order by id", response = OrderDto.class)
    public OrderDto findById(@PathVariable Long id) {
        return modelMapper.map(orderService.findById(id), OrderDto.class);
    }

    @PostMapping("/orders")
    @ApiOperation(value = "create order", response = OrderDto.class)
    public OrderDto save(@RequestBody OrderDto orderDto) {
        Order order = orderService.save(modelMapper.map(orderDto, Order.class));
        return modelMapper.map(order, OrderDto.class);
    }
}
