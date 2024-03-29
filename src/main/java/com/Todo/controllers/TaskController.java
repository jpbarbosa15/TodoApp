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

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
        TaskDTO taskDTO = taskService.findById(id);
        return ResponseEntity.ok(taskDTO);
    }


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

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        taskDTO = taskService.update(id, taskDTO);
        return ResponseEntity.ok(taskDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
