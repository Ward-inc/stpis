package demolab.stpiss.controllers;

import demolab.stpiss.models.Development;
import demolab.stpiss.models.Order;
import demolab.stpiss.models.Person;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.services.LoginService;
import demolab.stpiss.types.ChangePassTemplate;
import demolab.stpiss.types.DevOrderTemplate;
import demolab.stpiss.types.loginExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mark")
public class MarkController {


    public final EmployeeServices empService;


    @Autowired
    public MarkController(EmployeeServices empService) {
        this.empService = empService;
    }

    @GetMapping
    public String init() {
        return "Mark account";
    }

    @PostMapping("/orderdev")
    public loginExeption OrderDev(@RequestBody DevOrderTemplate data) {

        loginExeption ex = new loginExeption();

        ex.setExeption("successful");
       empService.addDevOrder(data);




      return ex;
    }
    @PostMapping("/changepass")
    public loginExeption changePass (@RequestBody ChangePassTemplate data){
        loginExeption exx = new loginExeption();
        exx.setExeption("password changed");
        empService.changePass(data);

        return exx;
    }
    @GetMapping("/contacts")
    public List<Person> users() {
        return empService.AllContacts();
    }
}
