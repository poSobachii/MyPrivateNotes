package JavaBasics.a5_Arrays_and_Collections.a53_Lists;

import JavaBasics.a5_Arrays_and_Collections.Plane;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
//        arrayList();
//        linkedList();
//        listManipulation();
        planeListManipulation();
    }

    private static void linkedList() {
    }

    private static void arrayList() {
        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        System.out.println(cars.get(0));
        cars.set(3, "Opel");
        cars.remove(2);
        System.out.println(cars);
    }

    static void listManipulation(){
        List<String> cars = new ArrayList<>();
        cars.add("Moskvich");
        cars.clear();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);
        Collections.sort(cars);
        Collections.reverse(cars);
        cars.sort(Collections.reverseOrder());
        System.out.println(cars);

        cars.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                if (s1.contains("o")) {
                    return 1;
                } else return -1;

            }
        });
        System.out.println(cars);

    }

    static void planeListManipulation() {
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane("Boeing", 12, "Big"));
        planes.add(new Plane("Douglas", 46, "Small"));
        planes.add(new Plane("Airbus", 20, "Very Big"));
        planes.add(new Plane("Douglas", 37, "Very Small"));
        planes.add(new Plane("Bombardier", 8));

        System.out.println(planes);
        Collections.sort(planes);
        System.out.println(planes);
        Collections.reverse(planes);
        System.out.println(planes);

        planes.sort(Collections.reverseOrder());
        System.out.println(planes);

        planes.sort(new PlaneComparator());
        System.out.println(planes);

        Comparator<Plane> compareByModel =
                (Plane o1, Plane o2) -> o2.getType().compareTo(o1.getType());

        planes.sort(compareByModel);
        System.out.println(planes);

    }
}
