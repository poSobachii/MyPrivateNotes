package JavaBasics.a3_OOP.a34_Polymorphism;

public class Application {

    public static void main(String[] args) {

//        overRidingMethods();
//        implementingMethods();
        overloadingMeans();

    }

    private static void overloadingMeans() {
        BWM bmw = new BWM();
        bmw.allocatePassengers("Jhon");
        bmw.allocatePassengers("Jhon", "Jack");
        bmw.allocatePassengers("Jhon", "Jack", 70);
        bmw.allocatePassengers("Jhon", "Jack", "Willis");
        bmw.allocatePassengers("Jhon", "Jack", "Willis", "Kate");
    }

    private static void implementingMethods() {
        int distance = 1000;

        Car bmw = new BWM();
        bmw.defaultMethod();
        bmw.drive();
        System.out.println(bmw.getCarsModel());
        System.out.printf("Fuel consumed -> %20.2f%n", bmw.fuelConsumed(distance));

        Volga volga = new Volga();
        volga.defaultMethod();
        volga.drive();
        System.out.println(volga.getCarsModel());
        System.out.printf("Fuel consumed -> %20.2f%n", volga.fuelConsumed(distance));


    }

    private static void overRidingMethods() {
        Polygon p1 = new Polygon();
        p1.render();
        Square s1 = new Square();
        s1.render();
        Circle c1 = new Circle();
        c1.render();
    }

}
