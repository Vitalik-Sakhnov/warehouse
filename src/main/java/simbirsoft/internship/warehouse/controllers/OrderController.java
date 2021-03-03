package simbirsoft.internship.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.services.impl.OrderServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<OrderDto> findAll() {
        return modelMapper.map(
                orderService.findAll(),
                new TypeToken<List<OrderDto>>() {
                }.getType()
        );
    }

    @GetMapping("/id")
    public OrderDto findById(@RequestParam(name = "productId") Long orderId) {
        return modelMapper.map(orderService.findById(orderId), OrderDto.class);
    }

    @PostMapping("/new")
    public OrderDto save(@RequestBody OrderDto orderDto) {
        Order order = orderService.save(modelMapper.map(orderDto, Order.class));
        return modelMapper.map(order, OrderDto.class);
    }
}
