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
        @PostMapping("/apiAdmin/deleteTask")
        public ServResponce deleteUser(@RequestBody DeleteReguest request) {
            log.info("deleteTask");
            String name = request.getName();

            if (name != null) {
                TaskE deleteTask = taskService.deleteTask(name);
                return new ServResponce(true, "User is deleted", deleteTask);
            } else {
                return new ServResponce(false, "Null param", null);
            }
        }
        @PostMapping("/apiAdmin/addContact")
        public ServResponce addContact( @RequestBody @Validated newTaskRequest request) throws ControllerException {
            log.info("addContact");
            String name_task = request.getName_task();
            String completed = request.getCompleted();

            if (name_task != null && completed != null) {
                TaskE task = taskService.saveTask(name_task, completed);
                if (task != null) {
                    return new ServResponce(true, "Successful", task);
                } else{
                    throw  new ControllerException("name task null");
                }
            } return new ServResponce(false,"ERROR",null);
        }
}
