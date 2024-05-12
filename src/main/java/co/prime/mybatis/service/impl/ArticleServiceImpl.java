package co.prime.mybatis.service.impl;

import co.prime.mybatis.model.Article;
import co.prime.mybatis.repository.ArticleRepository;
import co.prime.mybatis.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    @Override
    public List<Article> findAll() {
        return articleRepository.select();
    }
}
