package demolab.stpiss.repo;


import demolab.stpiss.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo extends JpaRepository<Order, Long> {
}
