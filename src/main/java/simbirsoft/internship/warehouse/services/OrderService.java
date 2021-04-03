package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.dto.PurchaseDto;
import simbirsoft.internship.warehouse.dto.SalesInformationDto;
import simbirsoft.internship.warehouse.dto.SoldProductDto;

import java.util.List;

public interface OrderService {
    /**
     * Метод добавления заказа.
     *
     * @param purchaseDto - заказ, который нужно добавить
     * @return - добавленный заказ
     */
    OrderDto save(PurchaseDto purchaseDto);

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
     * Метод удаления заказа по его id.
     *
     * @param orderId - id заказа, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    boolean deleteById(Long orderId);

    /**
     * Метод получения информации о выручке магазинов.
     *
     * @return информацию по выручке магазинов.
     */
    List<SalesInformationDto> salesInformation();

    /**
     * Метод получения информации о среднем чеке магазинов.
     *
     * @return информация о среднем чеке магазинов
     */
    List<SalesInformationDto> checkInformation();

    /**
     * Метод получения информации о проданных товарах по магазинам.
     *
     * @return информацию о проданных товарах в магазинах
     */
    List<SoldProductDto> soldProductInformation();
}
