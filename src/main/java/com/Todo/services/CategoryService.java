package com.Todo.services;

import com.Todo.dto.CategoryDTO;
import com.Todo.model.Category;
import com.Todo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll(){
        List<Category> result = categoryRepository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }

    public CategoryDTO insert(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category = categoryRepository.save(category);
        return new CategoryDTO(category);
    }



}
