package gamma.repository;

import gamma.entity.BettingStrategy;
import gamma.entity.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BettingStrategyRepository extends JpaRepository<BettingStrategy, Long> {

}
