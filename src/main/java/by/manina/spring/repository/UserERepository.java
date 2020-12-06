package by.manina.spring.repository;

import by.manina.spring.entity.RoleE;
import by.manina.spring.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserERepository extends JpaRepository<UserE,Integer> {
    UserE findByLogin(String login);
}


