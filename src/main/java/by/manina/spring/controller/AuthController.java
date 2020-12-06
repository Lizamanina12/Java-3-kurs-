package by.manina.spring.controller;

import by.manina.spring.config.jwt.JwtProvider;
import by.manina.spring.entity.UserE;
import by.manina.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest){
        UserE userE=new UserE();
        userE.setPassword(registrationRequest.getPassword());
        userE.setLogin(registrationRequest.getLogin());
        userService.saveUser(userE);
        return "OK";
    }
    @PostMapping("/auth")
    public AuthResponse authResponse(@RequestBody AuthRequest request){
      UserE userE =userService.findByLoginAndPassword(request.getLogin(),request.getPassword());
  String token=jwtProvider.generateToken(userE.getLogin());
  return new AuthResponse(token);
    }


}
