package com.Todo.dto;

import com.Todo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
    }
}
