package com.Todo.controllers;

import com.Todo.dto.CategoryDTO;
import com.Todo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> list = categoryService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> Insert(@RequestBody CategoryDTO categoryDTO){
        categoryDTO = categoryService.insert(categoryDTO);
        return ResponseEntity.ok().body(categoryDTO);
    }
}
