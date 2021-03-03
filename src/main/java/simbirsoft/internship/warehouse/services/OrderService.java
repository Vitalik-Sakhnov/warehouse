package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.Order;

import java.util.List;

public interface OrderService {
    /**
     * Метод добавления заказа.
     *
     * @param order - заказ, который нужно добавить
     * @return - добавленный заказ
     */
    Order save(Order order);

    /**
     * Метод поиска всех заказов.
     *
     * @return - список всех заказов
     */
    List<Order> findAll();

    /**
     * Метод поиска заказа по его id.
     *
     * @param orderId - id заказа, который нужно найти
     * @return - заказ, id которого равен передаваемому
     */
    Order findById(Long orderId);
}
