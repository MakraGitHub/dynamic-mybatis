package co.prime.mybatis.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {

    private Integer id;
    @NotBlank(message = "Category name is required...!")
    private String name;

}
