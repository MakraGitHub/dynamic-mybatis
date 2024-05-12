package co.prime.mybatis.service;

import co.prime.mybatis.model.Category;

import java.util.List;

public interface CategoryService {
    /*
    Add new category
    CategoryPOJO(Model,Entities)
    * */
    void addNewCategory(Category category);
    /*
    * FindAll categories*/
    List<Category> findAll();

    void deleteById(Integer id);

    Category findById(Integer id);

    void updateCategoryById(Integer id, Category newCategory);

}
