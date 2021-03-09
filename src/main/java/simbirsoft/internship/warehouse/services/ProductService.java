package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.ProductDto;

import java.util.List;

public interface ProductService {
    /**
     * Метод добавления товара.
     *
     * @param productDto - товар, который нужно добавить
     * @return - добавленный товар
     */
    ProductDto save(ProductDto productDto);

    /**
     * Метод поиска всех товаров.
     *
     * @return - список всех товаров
     */
    List<ProductDto> findAll();

    /**
     * Метод поиска товара по его id.
     *
     * @param productId - id товара, который нужно найти
     * @return - товар, у которого id равно передаваемому
     */
    ProductDto findById(Long productId);

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
     * @param productDto - новый товар
     * @return - обновлённый товар
     */
    ProductDto update(ProductDto productDto);
}
