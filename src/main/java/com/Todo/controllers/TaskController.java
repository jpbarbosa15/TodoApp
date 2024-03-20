package com.Todo.controllers;


import com.Todo.dto.TaskDTO;
import com.Todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping()
    public ResponseEntity<Page<TaskDTO>> findAll (Pageable pageable){
        Page<TaskDTO> list = taskService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<TaskDTO> insert(@RequestBody TaskDTO taskDTO){
        taskDTO = taskService.insert(taskDTO);
        return ResponseEntity.ok().body(taskDTO);
    }

}
