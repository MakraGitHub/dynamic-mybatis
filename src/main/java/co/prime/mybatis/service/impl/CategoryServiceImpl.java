package co.prime.mybatis.service.impl;

import co.prime.mybatis.model.Category;
import co.prime.mybatis.repository.CategoryRepository;
import co.prime.mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

   private final CategoryRepository categoryRepository;
    @Override
    public void addNewCategory(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.select();
    }

    @Override
    public void deleteById(Integer id) {
      int affectedRow =  categoryRepository.deleteById(id);
        System.out.println(affectedRow);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.selectById(id);
    }

    @Override
    public void updateCategoryById(Integer id, Category newCategory) {
        newCategory.setId(id);
        categoryRepository.updateById(newCategory);
    }
}
