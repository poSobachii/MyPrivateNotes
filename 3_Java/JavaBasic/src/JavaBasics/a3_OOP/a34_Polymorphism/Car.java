package JavaBasics.a3_OOP.a34_Polymorphism;

public interface Car {

    String name = "This is Car -> ";

    String getCarsModel();

    void drive();

    double fuelConsumed(int distance);

    default void defaultMethod() {
        System.out.println("Car just exists");
    }

    static void staticMethod() {
        System.out.println("Just a static method");
    }
}
