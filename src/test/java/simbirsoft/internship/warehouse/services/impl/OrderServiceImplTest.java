package simbirsoft.internship.warehouse.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.repositories.OrderRepository;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private ModelMapper modelMapper;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void save() {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(new Date(2021 - 10 - 10));
        orderDto.setOrderPrice(2015.0);
        orderDto.setId(15L);

        Order order = modelMapper.map(orderDto, Order.class);

        Mockito.verify(orderRepository, Mockito.times(1)).save(order);
    }
}