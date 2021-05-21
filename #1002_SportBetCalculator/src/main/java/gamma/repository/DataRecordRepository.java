package gamma.repository;

import gamma.entity.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRecordRepository  extends JpaRepository<DataRecord, Long> {

    @Query("SELECT r FROM DataRecord r WHERE r.betStatus != 'CLOSED'")
    List<DataRecord> findNonHidden();
}
