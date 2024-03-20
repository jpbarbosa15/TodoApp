package com.Todo.services;

import com.Todo.dto.TaskDTO;
import com.Todo.model.Category;
import com.Todo.model.Task;
import com.Todo.model.TaskStatus;
import com.Todo.repositories.CategoryRepository;
import com.Todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public Page<TaskDTO> findAll(Pageable pageable){
        Page<Task> result = taskRepository.findAll(pageable);
        return result.map(x -> new TaskDTO(x));
    }

    public TaskDTO insert(TaskDTO taskDTO){
        Task task = new Task();
        taskDTO.setStatus(TaskStatus.TODO);
        copyDtoToEntity(taskDTO, task);
        task = taskRepository.save(task);
        return new TaskDTO(task);

    }



    private void copyDtoToEntity(TaskDTO taskDTO, Task task){
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setStatus(taskDTO.getStatus());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        Category category = categoryRepository.getReferenceById(taskDTO.getCategory().getId());
        task.setCategory(category);
    }
}
