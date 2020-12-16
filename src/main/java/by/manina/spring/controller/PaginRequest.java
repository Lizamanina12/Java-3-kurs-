package by.manina.spring.controller;

import lombok.Data;

@Data
public class PaginRequest {
    private Integer page;
    private Integer counter;
    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }
    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }
}
