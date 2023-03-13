package demolab.stpiss.controllers;

import demolab.stpiss.models.Person;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.ChangePassTemplate;
import demolab.stpiss.types.DevOrderTemplate;
import demolab.stpiss.types.loginExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dev")
public class DevelopController {

    public final EmployeeServices empService;

    @Autowired
    public DevelopController(EmployeeServices empService) {
        this.empService = empService;
    }

    @GetMapping
    public String init() {
        return "Dev account:";
    }


    @GetMapping("/contacts")
    public List<Person> users() {
        return empService.AllContacts();
    }


    @PostMapping("/readyorder")
    public loginExeption devOrder (@RequestBody DevOrderTemplate data){
loginExeption exx = new loginExeption();
exx.setExeption("project readiness confirmed");
       String ex = empService.readyOrder(data);

return exx;
    }

    @PostMapping("/changepass")
    public loginExeption changePass (@RequestBody ChangePassTemplate data){
        loginExeption exx = new loginExeption();
        exx.setExeption("password changed");
       empService.changePass(data);

        return exx;
    }
}
