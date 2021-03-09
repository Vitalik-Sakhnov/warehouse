package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.OrderDto;

import java.util.List;

public interface OrderService {
    /**
     * Метод добавления заказа.
     *
     * @param orderDto - заказ, который нужно добавить
     * @return - добавленный заказ
     */
    OrderDto save(OrderDto orderDto);

    /**
     * Метод поиска всех заказов.
     *
     * @return - список всех заказов
     */
    List<OrderDto> findAll();

    /**
     * Метод поиска заказа по его id.
     *
     * @param orderId - id заказа, который нужно найти
     * @return - заказ, id которого равен передаваемому
     */
    OrderDto findById(Long orderId);
}
