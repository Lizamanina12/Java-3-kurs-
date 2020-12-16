package by.manina.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestSecurityController {
  @GetMapping("/admin/get")
  public String getAdmin(){
      return "Hi admin";
  }

}
