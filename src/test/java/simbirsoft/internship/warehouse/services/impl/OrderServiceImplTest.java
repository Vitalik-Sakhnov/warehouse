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
import simbirsoft.internship.warehouse.dto.SalesInformationDto;
import simbirsoft.internship.warehouse.dto.SoldProductDto;
import simbirsoft.internship.warehouse.entities.Consumption;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.repositories.OrderRepository;

import java.util.Date;
import java.util.List;

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
        order.setConsumptions(null);

        Mockito.verify(orderRepository, Mockito.times(0)).save(order);
    }

    @Test
    void salesInformation() {
        Mockito.verify(orderRepository, Mockito.times(0)).salesSum();
    }

    @Test
    void checkInformation() {
        Mockito.verify(orderRepository, Mockito.times(0)).averageCheck();
    }

    @Test
    void soldProductInformation() {
        Mockito.verify(orderRepository, Mockito.times(0)).soldProduct();
    }
}