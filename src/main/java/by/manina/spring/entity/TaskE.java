package by.manina.spring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
public class TaskE {
    public TaskE(){

    }
    public TaskE(String name_task , String completed) {

        this.name_task=name_task;
        this.completed=completed;
    }
   // @Column
   // private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String name_task;

    @Column
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
