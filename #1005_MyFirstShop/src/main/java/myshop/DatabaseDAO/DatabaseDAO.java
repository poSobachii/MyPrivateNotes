package myshop.DatabaseDAO;

import myshop.Entities.BasicWare;

import java.util.List;

public interface DatabaseDAO {
    void fetchWare(String insert);
    List<?> getAllWares(String wareType);
    BasicWare getOneItem(Long id);
}
