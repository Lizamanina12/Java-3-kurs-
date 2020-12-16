package by.manina.spring.service;

import by.manina.spring.controller.ServResponce;
import by.manina.spring.entity.RoleE;
import by.manina.spring.entity.TaskE;
//import by.manina.spring.repository.TaskERepository;
import by.manina.spring.entity.UserE;
import by.manina.spring.repository.TaskERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskERepository taskERepository;

    public List<TaskE> getAllTask(int pagePar, int limit){
        List<TaskE> result = new ArrayList<>();
        List<TaskE> list = taskERepository.findAll();
        long totalUsers = taskERepository.count();

        int totalPage =0;
        if(totalUsers/limit>(int)(totalUsers/limit)){
            totalPage = (int)(totalUsers/limit) + 1;
        }else{
            totalPage = (int)(totalUsers/limit);
        }

        int currentPage = pagePar-1;
        if(totalPage<pagePar){
            currentPage = totalPage;
        }
        if((pagePar-1)<0){
            currentPage=0;
        }

        long startPos = currentPage*limit;
        long endPos= (currentPage+1)*limit;
        if((currentPage+1)*limit>totalUsers){
            endPos=totalUsers;
        }
        long index =0;

        for (TaskE task:list) {
            if(index>=startPos&&index<endPos) {
                result.add(task);
            }
            index++;
        }
        return result;
    }
    public List<TaskE> searchTask(String inform,int pagePar, int limit) {
        List<TaskE> result = new ArrayList<>();
        List<TaskE> list = new ArrayList<>();
        for (TaskE task : taskERepository.findAll()) {
            if (task.getName_task().contains(inform))
            {
                list.add(task);
            }
        }
        long totalUsers = taskERepository.count();
        int totalPage = 0;
        if (totalUsers / limit > (int) (totalUsers / limit)) {
            totalPage = (int) (totalUsers / limit) + 1;
        } else {
            totalPage = (int) (totalUsers / limit);
        }

        int currentPage = pagePar - 1;
        if (totalPage < pagePar) {
            currentPage = totalPage;
        }
        if ((pagePar - 1) < 0) {
            currentPage = 0;
        }

        long startPos = currentPage * limit;
        long endPos = (currentPage + 1) * limit;
        if ((currentPage + 1) * limit > totalUsers) {
            endPos = totalUsers;
        }
        long index = 0;

        for (TaskE task : list) {
            if (index >= startPos && index < endPos) {
                result.add(task);
            }
            index++;
        }
        return result;
    }


}
