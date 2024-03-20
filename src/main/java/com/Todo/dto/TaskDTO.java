package com.Todo.dto;

import com.Todo.model.Category;
import com.Todo.model.Task;
import com.Todo.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    private Long id;

    private String name;

    private TaskStatus status;

    private String description;

    private LocalDate dueDate;

    private CategoryDTO category;

    public TaskDTO(Task task){
        this.id = task.getId();
        this.name = task.getName();
        this.status = task.getStatus();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        CategoryDTO categoryDTO = new CategoryDTO(task.getCategory());
        this.category = categoryDTO;
    }

}
