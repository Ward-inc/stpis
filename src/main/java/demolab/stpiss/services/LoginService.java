package demolab.stpiss.services;

import demolab.stpiss.models.Person;
import demolab.stpiss.repo.personRepo;
import demolab.stpiss.types.loginTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    public personRepo personRepo;

    @Autowired
    public LoginService(personRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Integer findEmploeeByLoginData(loginTemplate data){

        List<Person> list = personRepo.findAll();
        for (Person emploee: list) {
            if(emploee.getLogin().equals(data.login) && emploee.getPassword().equals(data.password))
                return 1;
        }

            return 0;



    }
}
