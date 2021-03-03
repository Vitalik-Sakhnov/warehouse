package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.Product;
import simbirsoft.internship.warehouse.repositories.ProductRepository;
import simbirsoft.internship.warehouse.services.ProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Метод добавления товара.
     *
     * @param product - товар, который нужно добавить
     * @return - добавленный товар
     */
    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    /**
     * Метод поиска всех товаров.
     *
     * @return - список всех товаров
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Метод поиска товара по его id.
     *
     * @param productId - id товара, который нужно найти
     * @return - товар, у которого id равно передаваемому
     */
    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    /**
     * Метод удаления товара по его id.
     *
     * @param productId - id товара, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    @Override
    public boolean deleteById(Long productId) {
        Product product = findById(productId);
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
     * @param product - новый товар
     * @return - обновлённый товар
     */
    @Override
    public Product update(Product product) {
        if (product.getId() != null) {
            productRepository.save(product);
        }
        return product;
    }
}
