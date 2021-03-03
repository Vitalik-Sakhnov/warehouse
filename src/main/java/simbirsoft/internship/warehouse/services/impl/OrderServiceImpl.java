package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.repositories.OrderRepository;
import simbirsoft.internship.warehouse.services.OrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Метод добавления заказа.
     *
     * @param order - заказ, который нужно добавить
     * @return - добавленный заказ
     */
    @Override
    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }

    /**
     * Метод поиска всех заказов.
     *
     * @return - список всех заказов
     */
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    /**
     * Метод поиска заказа по его id.
     *
     * @param orderId - id заказа, который нужно найти
     * @return - заказ, id которого равен передаваемому
     */
    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }
}
