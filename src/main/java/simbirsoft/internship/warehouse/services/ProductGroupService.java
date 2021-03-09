package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.ProductGroupDto;

import java.util.List;

public interface ProductGroupService {
    /**
     * Метод добавления товарной группы.
     *
     * @param productGroupDto - товарная группа, которую нужно добавить
     * @return - добавленную товарную группу
     */
    ProductGroupDto save(ProductGroupDto productGroupDto);

    /**
     * Метод поиска всех товарных групп.
     *
     * @return - список всех товарных групп
     */
    List<ProductGroupDto> findAll();

    /**
     * Метод поиска товарной группы по её id.
     *
     * @param productGroupId - id товарной группы, которую нужно найти
     * @return - товарную группу, у которой id равно передаваемому
     */
    ProductGroupDto findById(Long productGroupId);

    /**
     * Метод поиска товарной группы по её наименованию.
     *
     * @param productGroupName - наименование товарной группы, которую нужно найти
     * @return - товарную группу, у которой наименование равно передаваемому
     */
    ProductGroupDto findByName(String productGroupName);

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
     * @param productGroupDto - новая товарная группа
     * @return - обновлённая товарная группа
     */
    ProductGroupDto update(ProductGroupDto productGroupDto);
}
