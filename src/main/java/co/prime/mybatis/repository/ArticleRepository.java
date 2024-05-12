package co.prime.mybatis.repository;

import co.prime.mybatis.model.Article;
import co.prime.mybatis.model.Category;
import co.prime.mybatis.repository.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleRepository {

    @SelectProvider(
            type = ArticleProvider.class,
    method = "buildSelectSql")
    //Declare Results Map
    @Results(id = "articleResultMap", value = {
            //Make the different to map column articles
            @Result(column = "id", property = "id"),
          /*  @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),
            @Result(column = "status", property = "status"),*/
            @Result(column = "cate_id", property = "category",
                    one = @One(select = "selectArticleCategory")
            )
    })
    List<Article> select();

    @SelectProvider(type = ArticleProvider.class,
    method = "buildSelectArticleCategorySql")

    Category selectArticleCategory(@Param("cate_id") Integer cateId);

    @Select("SELECT *FROM get_article_count(#{keyword})")
    int countArticle(@Param("keyword") String keyword);

    @Select("SELECT *FROM search_articles(#{keyword})")
    List<Article> searchArticles(@Param("keyword") String keyword);


}
