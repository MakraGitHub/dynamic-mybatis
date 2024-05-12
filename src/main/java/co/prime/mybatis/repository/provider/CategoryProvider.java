package co.prime.mybatis.repository.provider;

import org.apache.ibatis.jdbc.SQL;

//Build dynamic sql
public class CategoryProvider {

    public String buildInsertSql() {
        return new SQL(){{
        //TODO
            INSERT_INTO("categories");
            VALUES("name","#{cate.name}");
        }}.toString();
    }

    public String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM("categories");
            ORDER_BY("id DESC");
        }}.toString();
    }

    public String buildDeleteSql(){
        return new SQL(){{
           DELETE_FROM("categories");
           WHERE("id = #{id}");
        }}.toString();
    }

    public String selectByIdSql(){
        return new SQL(){{
              SELECT("*");
              FROM("categories");
              WHERE("id =#{id}");
        }}.toString();
    }

    public String updateByIdSql(){
        return new SQL(){{
            UPDATE("categories");
            SET("name =#{cate.name}");
            WHERE("id =#{cate.id}");
        }}.toString();
    }


}
