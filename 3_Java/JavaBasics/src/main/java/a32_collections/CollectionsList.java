package a32_collections;

import java.util.Arrays;
import java.util.List;

public class CollectionsList {

    public static void main(String[] args) {
        listManipulation();
    }

    static void listManipulation(){
        String[] stringArray1 = {"Bob", "Michael", "Jack"};
        List<String> stringList1 = Arrays.asList(stringArray1);
        System.out.println("list of same values: " + stringList1.toString());
    }
}
