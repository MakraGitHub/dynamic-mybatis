package co.prime.mybatis.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {
    public String buildCountArticleSql(){
        return new SQL(){{
            SELECT("*");
            FROM("get_article_count(#{keyword})");
        }}.toString();
    }

    public String buildSelectArticleCategorySql(){
        return new SQL(){{
            SELECT("*");
            FROM("categories");
            WHERE("id = #{cate_id}");
        }}.toString();
    }

    public String buildSelectSql(){
        return new SQL(){{
        SELECT("*");
        FROM("articles");
        }}.toString();
    }
}
