package demolab.stpiss.repo;

import demolab.stpiss.models.Development;
import org.springframework.data.jpa.repository.JpaRepository;

public interface devRepo extends JpaRepository<Development, Long> {

}
