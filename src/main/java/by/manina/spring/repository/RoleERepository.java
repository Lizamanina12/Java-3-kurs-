package by.manina.spring.repository;

import by.manina.spring.entity.RoleE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleERepository extends JpaRepository<RoleE,Integer> {
        RoleE findByName(String name);
    }

