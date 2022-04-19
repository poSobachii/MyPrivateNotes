package JavaBasics.a5_Arrays_and_Collections;

public class Plane implements Comparable<Plane>{

    String model;
    int age;
    String type = "noType";

    public Plane(String text, int age) {
        this.model = text;
        this.age = age;
    }

    public Plane(String text, int age, String type) {
        this.model = text;
        this.age = age;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "text='" + model + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Plane plane) {
        return this.model.compareTo(plane.model);
    }
}
