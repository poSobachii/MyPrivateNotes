package myshop.BasketPack;

import myshop.H2database.DatabaseHandler;
import myshop.Entities.BasicWare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketOrder {


    private static DatabaseHandler databaseCommander;
    static List<BasicWare> wareList = new ArrayList<>();

    @Autowired
    public BasketOrder(DatabaseHandler dbCommander){
        BasketOrder.databaseCommander = dbCommander;
    }

    @Autowired

    public static void addOrder(String wareCode) {
        wareList.add(databaseCommander.getOneItem(Long.parseLong(wareCode)));
    }



    public static void printJSBasket(){
        System.out.println("size is: " + wareList.size());
            int order = 1;
            for ( BasicWare r : wareList ) {
            System.out.println("order No:" + order + " - " + r.getWareName()
                    + "," + r.getId());
            ++order;
            }
    }

    public static StringBuilder write() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BasicWare e : wareList) {
            stringBuilder.append("<div class=\"col-sm-4\" style=\"background-color:transparent;\">" +
                    "<img src=\"pics/"+ e.getClass().getSimpleName() + "/" + e.getImgSource() + ".png\"\" +\n" +
                    "                             width=\"250\" height=\"225\" alt=\"there is no picture :(\" />"+
                    e.getWareName() + "</br>" +
                    e.getWarePrice() + "</br>" +
                    e.getPriceQuantity() + "</br></div>");


        }
        return stringBuilder;
    }

    public static List<BasicWare> getWareList() {
        return wareList;
    }
}
