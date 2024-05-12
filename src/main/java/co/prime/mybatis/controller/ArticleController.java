package co.prime.mybatis.controller;

import co.prime.mybatis.model.Article;
import co.prime.mybatis.service.ArticleService;
import co.prime.mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping
    public String requestViewArticle(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles",articles);
        return "page/article/article-main";
    }
    @GetMapping("/save")
    public String viewSaveArticle(Article article, Model model){
        model.addAttribute("article",article);
        model.addAttribute("categories",categoryService.findAll());
        return "page/article/article-save";
    }

    @PostMapping("/save")
    public String saveArticle(Article article){
        System.out.println(article);
        return "redirect:/article";
    }

}
