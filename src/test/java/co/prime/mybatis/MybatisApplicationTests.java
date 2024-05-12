package co.prime.mybatis;
import co.prime.mybatis.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testSelectArticles(){
        System.out.println(articleRepository.select());
    }

   @Test
    void testCountArticleByKeyword(){
       //TODO
       System.out.println(articleRepository.countArticle("java"));
   }

   @Test
    void testSearchArticles(){
       System.out.println(articleRepository.searchArticles("java"));
   }

}
