package BarkingApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingRepository extends JpaRepository<Logging, Long> {

}
