package by.manina.spring.service;

import by.manina.spring.config.jwt.CustomUserDetails;
import by.manina.spring.entity.UserE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserE userEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomDetails(userEntity);
    }
}