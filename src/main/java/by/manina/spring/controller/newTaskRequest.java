package by.manina.spring.controller;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class newTaskRequest {
    private String name_task;
    private String completed;


    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }



}
