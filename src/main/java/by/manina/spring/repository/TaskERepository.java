package by.manina.spring.repository;

import by.manina.spring.entity.TaskE;
import by.manina.spring.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskERepository extends JpaRepository<TaskE,Integer> {

}
