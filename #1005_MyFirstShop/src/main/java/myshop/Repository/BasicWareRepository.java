package myshop.Repository;

import myshop.Entities.BasicWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicWareRepository extends JpaRepository<BasicWare, Long> {

    List<BasicWare> findBywareType(String wareType);
}
