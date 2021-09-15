package microservice.repository;

import microservice.entity.DebtCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<DebtCard, Long> {

}
