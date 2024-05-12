package co.prime.mybatis.controller;

import co.prime.mybatis.model.Category;
import co.prime.mybatis.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

     @GetMapping
    public String requestViewCategory(Category category, Model model){
         model.addAttribute("category",category);
         model.addAttribute("categories",categoryService.findAll());
         return "page/category/cate-main";
     }

     @PostMapping("/save")
    public String saveCategory(@Valid Category category, BindingResult result, Model model){
         if(result.hasErrors()){
             return requestViewCategory(category, model);
         }
         System.out.println(category);
         if(category.getId() == null){
             categoryService.addNewCategory(category);

         }else {
             categoryService.updateCategoryById(category.getId(), category);
         }

         return "redirect:/category";
     }

     @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id){
         categoryService.deleteById(id);
         return "redirect:/category";
     }

     @GetMapping("/{id}/edit")
    public String editCategoryById(@PathVariable Integer id, Model model){
      Category category = categoryService.findById(id);
      return requestViewCategory(category, model);

     }

}
