package by.manina.spring.controller;

import by.manina.spring.config.jwt.JwtProvider;
import by.manina.spring.entity.UserE;
import by.manina.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(origins = "*", maxAge = 3600)
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
        userE.setEmail(registrationRequest.getEmail());
        userService.saveUser(userE);
        return "OK";
    }
    @PostMapping("/auth")
    public ServResponce auth(@RequestBody AuthRequest request){
        String num[]=new String[2];
        String log=request.getLogin();
        System.out.println(log);
        if(request.getLogin()!=null&&request.getPassword()!=null) {
            UserE userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
            if (userEntity != null ) {

                    String token = jwtProvider.generateToken(request.getLogin());
                    num[0]=token;
                    if(log.contains("лиза")){
                        num[1]="admin";
                    }
                    else{num[1]="user";}

                    return new ServResponce(true, "Successful",num);

               }
        }
        return new ServResponce(false, "Wrong login or password", null);
    }


}
