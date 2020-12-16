package by.manina.spring.controller;

import by.manina.spring.Exception.ControllerException;
import by.manina.spring.entity.TaskE;
import by.manina.spring.repository.TaskERepository;
import by.manina.spring.service.TaskService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.awt.SystemColor.info;
@Log4j2
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/api/getAllTask")

    public ServResponce getAllTask( @RequestBody PaginRequest request){
          Integer page = request.getPage();
        Integer limit = request.getCounter();
        log.info("getAllTask");
            if(page!=null&&limit!=null) {
                List<TaskE> tasks = taskService.getAllTask(page, limit);
                return new ServResponce(true, "Successful", tasks);
            }

        return new ServResponce(false,"Error",null);
    }
    @PostMapping("/api/searchTask")
    public ServResponce searchUser(@RequestBody SearchRequest request){
        log.info("searchTask");
        String inform = request.getInform();
        Integer page = request.getPage();
        Integer limit = request.getLimit();
        System.out.print(page);
        System.out.print(limit);
        System.out.println(inform);
            if(page!=null&&limit!=null) {
                List<TaskE> taskss = taskService.searchTask(inform,page, limit);
                return new ServResponce(true, "Successful", taskss);
            }

        return new ServResponce(false,"Error",null);

}
