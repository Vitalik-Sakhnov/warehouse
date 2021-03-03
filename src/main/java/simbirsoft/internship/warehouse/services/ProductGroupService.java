package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.ProductGroup;

import java.util.List;

public interface ProductGroupService {
    /**
     * Метод добавления товарной группы.
     *
     * @param productGroup - товарная группа, которую нужно добавить
     * @return - добавленную товарную группу
     */
    ProductGroup save(ProductGroup productGroup);

    /**
     * Метод поиска всех товарных групп.
     *
     * @return - список всех товарных групп
     */
    List<ProductGroup> findAll();

    /**
     * Метод поиска товарной группы по её id.
     *
     * @param productGroupId - id товарной группы, которую нужно найти
     * @return - товарную группу, у которой id равно передаваемому
     */
    ProductGroup findById(Long productGroupId);

    /**
     * Метод поиска товарной группы по её наименованию.
     *
     * @param productGroupName - наименование товарной группы, которую нужно найти
     * @return - товарную группу, у которой наименование равно передаваемому
     */
    ProductGroup findByName(String productGroupName);

    /**
     * Метод удаления товарной группы по её id.
     *
     * @param productGroupId - id товарной группы, которую нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    boolean deleteById(Long productGroupId);

    /**
     * Метод обновления товарной группы.
     *
     * @param productGroup - новая товарная группа
     * @return - обновлённая товарная группа
     */
    ProductGroup update(ProductGroup productGroup);
}
