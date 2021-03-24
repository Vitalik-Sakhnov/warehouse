package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.dto.PurchaseDto;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.repositories.OrderRepository;
import simbirsoft.internship.warehouse.services.ConsumptionService;
import simbirsoft.internship.warehouse.services.OrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;

    private ConsumptionService consumptionService;

    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ConsumptionService consumptionService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.consumptionService = consumptionService;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления заказа.
     *
     * @param purchaseDto - заказ, который нужно добавить
     * @return - добавленный заказ
     */
    @Override
    public PurchaseDto save(PurchaseDto purchaseDto) {
        Order order = orderRepository.save(modelMapper.map(orderDto, Order.class));
        return modelMapper.map(order, OrderDto.class);
    }

    /**
     * Метод поиска всех заказов.
     *
     * @return - список всех заказов
     */
    @Override
    public List<OrderDto> findAll() {
        return modelMapper.map(
                orderRepository.findAll(),
                new TypeToken<List<OrderDto>>() {
                }.getType()
        );
    }

    /**
     * Метод поиска заказа по его id.
     *
     * @param orderId - id заказа, который нужно найти
     * @return - заказ, id которого равен передаваемому
     */
    @Override
    public OrderDto findById(Long orderId) {
        Order order = null;
        try {
            order = orderRepository.findById(orderId).orElseThrow(
                    () -> new EntityNotFoundException("Entity not found")
            );
        } catch (EntityNotFoundException ex) {
            logger.error("EntityNotFoundException", ex);
            ex.printStackTrace();
        }
        return modelMapper.map(order, OrderDto.class);
    }

    /**
     * Метод обновления заказа.
     *
     * @param orderDto - новый заказ
     * @return - обновлённый заказ
     */
    @Override
    public OrderDto update(OrderDto orderDto) {
        return save(orderDto);
    }

    /**
     * Метод удаления заказа по его id.
     *
     * @param orderId - id заказа, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    @Override
    public boolean deleteById(Long orderId) {
        Order order = orderRepository.getOne(orderId);
        if (orderRepository.existsById(orderId)) {
            if (order.getConsumptions().isEmpty()) {
                orderRepository.deleteById(orderId);
                return true;
            }
        }
        return false;
    }
}
