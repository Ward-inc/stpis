package demolab.stpiss.services;


import demolab.stpiss.exeptions.NotFoundException;
import demolab.stpiss.models.Development;
import demolab.stpiss.models.HR;
import demolab.stpiss.models.Order;
import demolab.stpiss.models.Person;
import demolab.stpiss.repo.devRepo;
import demolab.stpiss.repo.hrRepo;
import demolab.stpiss.repo.orderRepo;
import demolab.stpiss.repo.personRepo;
import demolab.stpiss.types.ChangePassTemplate;
import demolab.stpiss.types.DevOrderTemplate;
import demolab.stpiss.types.hrCourseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {


    public demolab.stpiss.repo.personRepo personRepo;
    public demolab.stpiss.repo.orderRepo orderRepo;
    public demolab.stpiss.repo.devRepo devRepo;
    public demolab.stpiss.repo.hrRepo hrRepo;

    @Autowired
    public EmployeeServices(personRepo personRepo, orderRepo orderRepo, devRepo devRepo, hrRepo hrRepo) {
        this.personRepo = personRepo;
        this.orderRepo=orderRepo;
        this.devRepo=devRepo;
        this.hrRepo=hrRepo;
    }

    public Person changePass(ChangePassTemplate data){
        Optional<Person> emploee = personRepo.findById(data.idperson);
        if (emploee.isEmpty())
            throw new NotFoundException();

        Person per = new Person();
        per = emploee.get();
        per.setPassword(data.password);
        personRepo.save(per);

        return emploee.get();
    }
    public Person findEmploee(Long id){
        Optional<Person> emploee = personRepo.findById(id);
        if (emploee.isEmpty())
            throw new NotFoundException();

        return emploee.get();
    }
    public void removeEmployee(Long id) {
        personRepo.delete(findEmploee(id));
    }
    public List<Person> AllContacts() {
        return personRepo.findAll();
    }
    public void getCourseHr(hrCourseTemplate data){
        Optional<HR> emploee = hrRepo.findById(data.idhr);
        if (emploee.isEmpty())
            throw new NotFoundException();

HR hr_save = new HR();
hr_save=emploee.get();

hr_save.setCoursesnum(data.idcourse);
hrRepo.save(hr_save);


    }


public String readyOrder(DevOrderTemplate data){

    Optional<Order> emploee = orderRepo.findById(data.idorder);
    if (emploee.isEmpty()) {
        throw new NotFoundException();
    }
    Order order = new Order();
    order=emploee.get();

    order.setStatus("Готов");

    orderRepo.save(order);

return "ready";
}
    public Order addOrder(Order data) {
        return orderRepo.save(new Order(data.getOrdername(), data.getCost(), data.getPlatform(), data.getStatus()));
    }

    public Development findDev(Long id){
        Optional<Development> emploee = devRepo.findById(id);
        if (emploee.isEmpty())
            throw new NotFoundException();

        return emploee.get();
    }

    public Development addDevOrder(DevOrderTemplate dev){

        Development dev_save = new Development();

      dev_save =  findDev(dev.iddev);



        dev_save.setOrdernum(dev.idorder);



        devRepo.save(dev_save);

        return dev_save;
    }

}
