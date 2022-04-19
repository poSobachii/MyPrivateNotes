package JavaBasics.a3_OOP.a34_Polymorphism;

public class BWM implements Car{

    private String model = "BWM";
    private double consumptionCoef = 8.1;

    @Override
    public String getCarsModel() {
        return name + model;
    }

    @Override
    public void drive() {
        System.out.println(model + " drives");
    }

    @Override
    public double fuelConsumed(int distance) {
        return distance / 100 * consumptionCoef;
    }

    public void allocatePassengers(String pass1) {
        System.out.printf("%n%s is driving", pass1);
    }

    public void allocatePassengers(String pass1, String pass2) {
        System.out.printf("%n%s and %s are driving", pass1, pass2);
    }

    public void allocatePassengers(String pass1, String pass2, int speed) {
        System.out.printf("%n%s and %s are driving %d miles per hour", pass1, pass2, speed);
    }

    public void allocatePassengers(String pass1, String pass2, String pass3) {
        System.out.printf("%n%s, %s and %s are happily driving", pass1, pass2, pass3);
    }

    public void allocatePassengers(String pass1, String pass2, String pass3, String pass4) {
        System.out.printf("%n%s, %s, %s and %s are not happy ! But they are driving.", pass1, pass2, pass3, pass4);
    }

}
