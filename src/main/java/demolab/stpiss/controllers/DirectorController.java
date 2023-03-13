package demolab.stpiss.controllers;


import demolab.stpiss.models.Person;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.ChangePassTemplate;
import demolab.stpiss.types.loginExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("director")
public class DirectorController {

    public final EmployeeServices empService;

    @Autowired
    public DirectorController(EmployeeServices empService) {
        this.empService = empService;
    }


    @GetMapping
    public String init() {
        return "Director account";
    }

    @DeleteMapping("/employee/remove/{id}")
    public loginExeption deleteEmploee (@PathVariable Long id){
        empService.removeEmployee(id);
        loginExeption ex = new loginExeption();

        ex.setExeption("successful");
        return  ex;
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
