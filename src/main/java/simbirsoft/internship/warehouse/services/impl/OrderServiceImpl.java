package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.ConsumptionDto;
import simbirsoft.internship.warehouse.dto.OrderDto;
import simbirsoft.internship.warehouse.dto.PurchaseDto;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.repositories.OrderRepository;
import simbirsoft.internship.warehouse.repositories.ProductRepository;
import simbirsoft.internship.warehouse.services.ConsumptionService;
import simbirsoft.internship.warehouse.services.OrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private ConsumptionService consumptionService;
    private final ModelMapper modelMapper;
    private Double orderSum;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository,
                            ConsumptionService consumptionService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.consumptionService = consumptionService;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления заказа.
     * Сначала записываем в дто заказа дату и id заказа, далее считаем сумму заказа. Далее записываем сумму заказа
     * в дто заказа. После этого мапим эту дто в Order. Дальше создаем дто расхода и записываем в него заказ.
     * После этого записываем в дто расхода товар и его количество. После записи сохраняем расход.
     * После сохранения расхода, сохраняем заказ.
     *
     * @param purchaseDto - заказ, который нужно добавить
     * @return - добавленный заказ
     */
    @Override
    public OrderDto save(PurchaseDto purchaseDto) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(purchaseDto.getOrderDate());
        orderDto.setId(purchaseDto.getPurchaseId());

        // считаем сумму заказа
        purchaseDto.getProducts().forEach((key, value) -> {
            orderSum += productRepository.getOne(key).getPrice() * value;
        });
        orderDto.setOrderPrice(orderSum);

        Order order = modelMapper.map(orderDto, Order.class);

        ConsumptionDto consumptionDto = new ConsumptionDto();
        consumptionDto.setOrder(order);

        // записываем в расход товар и его количество, потом сохраняем
        purchaseDto.getProducts().forEach((key, value) -> {
            consumptionDto.setProduct(productRepository.getOne(key));
            consumptionDto.setGoodsQuantity(value);
            consumptionService.save(consumptionDto);
        });
        orderRepository.save(order);
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
