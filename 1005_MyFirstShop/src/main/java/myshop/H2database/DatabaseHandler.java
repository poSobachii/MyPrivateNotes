package myshop.H2database;

import myshop.DatabaseDAO.DatabaseDAO;
import myshop.Entities.BasicWare;
import myshop.Repository.BasicWareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseHandler implements DatabaseDAO {

    List<?> currentWare = new ArrayList<>();

    @Autowired
    BasicWareRepository basicWareRepository;

    @Override
    public void fetchWare(String insert) {
//        List<BasicWare> testList = basicWareRepository.findAll();
//        System.out.println("result="  + testList);

    }

    @Override
    public List<?> getAllWares(String wareType) {
        List<BasicWare> temo = basicWareRepository.findBywareType(wareType);
        return temo;
    }

    @Override
    public BasicWare getOneItem(Long id) {
        return basicWareRepository.findById(id).orElse(null);
    }

}
