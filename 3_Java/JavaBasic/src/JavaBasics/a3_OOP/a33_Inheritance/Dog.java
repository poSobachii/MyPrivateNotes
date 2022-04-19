package JavaBasics.a3_OOP.a33_Inheritance;

public class Dog extends Animal{

    String type = "Dog";
    String sound = "barks";
    int age = 10;
    String skinColor;


    public Dog() {
    }

    Dog(String skinColor) {
        this.skinColor = skinColor;
    }

    public void makeSound() {
        System.out.println(type + " makes " + sound);
    }

    public void makeSomething() {
        System.out.println("screaming...");
    }
}
