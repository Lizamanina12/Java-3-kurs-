package by.manina.spring.controller;
import lombok.Data;

@Data
public class DeleteReguest {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
