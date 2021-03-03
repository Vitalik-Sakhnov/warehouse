package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.Product;

import java.util.List;

public interface ProductService {
    /**
     * Метод добавления товара.
     *
     * @param product - товар, который нужно добавить
     * @return - добавленный товар
     */
    Product save(Product product);

    /**
     * Метод поиска всех товаров.
     *
     * @return - список всех товаров
     */
    List<Product> findAll();

    /**
     * Метод поиска товара по его id.
     *
     * @param productId - id товара, который нужно найти
     * @return - товар, у которого id равно передаваемому
     */
    Product findById(Long productId);

    /**
     * Метод удаления товара по его id.
     *
     * @param productId - id товара, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    boolean deleteById(Long productId);

    /**
     * Метод обновления товара.
     *
     * @param product - новый товар
     * @return - обновлённый товар
     */
    Product update(Product product);
}
