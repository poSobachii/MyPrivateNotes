package JavaBasics.a3_OOP.a34_Polymorphism;

public class Volga implements Car{

    private String model = "VOLGA";
    private double consumptionCoef = 16.1;

    @Override
    public String getCarsModel() {
        return name + model;
    }

    @Override
    public void drive() {
        System.out.println(model + " doesnt drive");
    }

    @Override
    public double fuelConsumed(int distance) {
        return distance / 100 * consumptionCoef;
    }
}
