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

    /**
     * Метод обновления заказа.
     *
     * @param orderDto - новый заказ
     * @return - обновлённый заказ
     */
    OrderDto update(OrderDto orderDto);

    /**
     * Метод удаления заказа по его id.
     *
     * @param orderId - id заказа, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    boolean deleteById(Long orderId);
}
