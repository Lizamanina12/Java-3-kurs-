package by.manina.spring.service;

import by.manina.spring.entity.RoleE;
import by.manina.spring.entity.UserE;
import by.manina.spring.repository.RoleERepository;
import by.manina.spring.repository.UserERepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserERepository userEntityRepository;

    @Autowired
    private RoleERepository roleEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserE saveUser(UserE userE){
        RoleE userRole = roleEntityRepository.findByName("ROLE_USER");
        userE.setRoleE(userRole);
        userE.setPassword(passwordEncoder.encode(userE.getPassword()));

        return userEntityRepository.save(userE);
    }
    public UserE findByLogin(String login)
    {
        return userEntityRepository.findByLogin(login);

    }
    public UserE findByLoginAndPassword(String login, String password) {
        UserE userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
