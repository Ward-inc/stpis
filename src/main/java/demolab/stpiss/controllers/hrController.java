package demolab.stpiss.controllers;

import demolab.stpiss.models.Person;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.ChangePassTemplate;
import demolab.stpiss.types.DevOrderTemplate;
import demolab.stpiss.types.hrCourseTemplate;
import demolab.stpiss.types.loginExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hr")
public class hrController {

    public final EmployeeServices empService;

    @Autowired
    public hrController(EmployeeServices empService) {
        this.empService = empService;
    }

    @GetMapping
    public String init() {
        return "Hr account:";
    }

    @PostMapping("/getcourse")
    public loginExeption hrCourse (@RequestBody hrCourseTemplate data){
        loginExeption ex = new loginExeption();

empService.getCourseHr(data);
ex.setExeption("course taken successfully");
        return ex;
    }


    @GetMapping("/contacts")
    public List<Person> users() {
        return empService.AllContacts();
    }
    @PostMapping("/changepass")
    public loginExeption changePass (@RequestBody ChangePassTemplate data){
        loginExeption exx = new loginExeption();
        exx.setExeption("password changed");
        empService.changePass(data);

        return exx;
    }
}
