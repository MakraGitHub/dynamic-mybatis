package co.prime.mybatis.repository;

import co.prime.mybatis.model.Category;
import co.prime.mybatis.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface CategoryRepository {
    @InsertProvider(type = CategoryProvider.class, method = "buildInsertSql")
    void insert(@Param("cate")Category category);

    @SelectProvider(type = CategoryProvider.class, method = "buildSelectSql")
    List<Category> select();

    @DeleteProvider(type = CategoryProvider.class, method = "buildDeleteSql")
    int deleteById(@Param("id") Integer id);

    @SelectProvider(type = CategoryProvider.class, method = "selectByIdSql")
    Category selectById(@Param("id") Integer id);

    @UpdateProvider(type = CategoryProvider.class, method = "updateByIdSql")
    void updateById(@Param("cate") Category newCategory);

}
