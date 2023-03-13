package demolab.stpiss.controllers;

import demolab.stpiss.services.LoginService;
import demolab.stpiss.types.loginExeption;
import demolab.stpiss.types.loginTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SignIn")
public class LoginController {

    public final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String init() {
        return "Post login and password";
    }

    @PostMapping("/enter")
    public loginExeption login(@RequestBody loginTemplate data) {

loginExeption ex = new loginExeption();

       if(loginService.findEmploeeByLoginData(data)==1) {

           ex.setExeption("successful authorization");

       }
       else
         {
             ex.setExeption("user don't exist");

       }
        return ex;
    }
}
