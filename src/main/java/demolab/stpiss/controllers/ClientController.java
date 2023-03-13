package demolab.stpiss.controllers;


import demolab.stpiss.models.Order;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.loginExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    public final EmployeeServices empService;

    @Autowired
    public ClientController(EmployeeServices empService) {
        this.empService = empService;
    }


    @GetMapping
    public String init() {
        return "Client order";
    }

    @PostMapping("/makeorder")
    public loginExeption makeOrder(@RequestBody Order data) {
        empService.addOrder(data);
        loginExeption ex = new loginExeption();
        ex.exeption="successful";
        return ex;
    }


}
