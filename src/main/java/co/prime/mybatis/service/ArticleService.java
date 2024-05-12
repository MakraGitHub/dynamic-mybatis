package co.prime.mybatis.service;

import co.prime.mybatis.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
}
