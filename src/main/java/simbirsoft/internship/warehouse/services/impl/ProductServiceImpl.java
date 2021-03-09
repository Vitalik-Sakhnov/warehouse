package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.ProductDto;
import simbirsoft.internship.warehouse.entities.Product;
import simbirsoft.internship.warehouse.repositories.ProductRepository;
import simbirsoft.internship.warehouse.services.ProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления товара.
     *
     * @param productDto - товар, который нужно добавить
     * @return - добавленный товар
     */
    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productRepository.save(modelMapper.map(productDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }

    /**
     * Метод поиска всех товаров.
     *
     * @return - список всех товаров
     */
    @Override
    public List<ProductDto> findAll() {
        return modelMapper.map(
                productRepository.findAll(),
                new TypeToken<List<ProductDto>>() {
                }.getType()
        );
    }

    /**
     * Метод поиска товара по его id.
     *
     * @param productId - id товара, который нужно найти
     * @return - товар, у которого id равно передаваемому
     */
    @Override
    public ProductDto findById(Long productId) {
        return modelMapper.map(
                productRepository.findById(productId).orElseThrow(
                        () -> new EntityNotFoundException("Entity not found")
                ),
                ProductDto.class
        );
    }

    /**
     * Метод удаления товара по его id.
     *
     * @param productId - id товара, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    @Override
    public boolean deleteById(Long productId) {
        Product product = productRepository.getOne(productId);
        if (productRepository.existsById(productId)) {
            if (product.getConsumptions().isEmpty() && product.getSupplies().isEmpty() &&
                    product.getWarehouses().isEmpty() && product.getWriteOffs().isEmpty()) {
                productRepository.deleteById(productId);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод обновления товара.
     *
     * @param productDto - новый товар
     * @return - обновлённый товар
     */
    @Override
    public ProductDto update(ProductDto productDto) {
        return save(productDto);
    }
}
