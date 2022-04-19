package JavaBasics.a3_OOP.a33_Inheritance;

public class Cat extends Animal{

    String type = "Cat";
    String sound = "meow";

    public void makeSound() {
        System.out.println(type + " makes " + sound);
    }
}
