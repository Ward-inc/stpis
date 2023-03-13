package demolab.stpiss.repo;

import demolab.stpiss.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepo extends JpaRepository<Person, Long> {
}
