package JavaBasics.a3_OOP.a33_Inheritance;

public class Application {

    public static void main(String[] args) {
//        singleInheritance();
//        advancedInheritance();
        multiLevelInheritance();

    }

    static void advancedInheritance() {
        Dog dog = new Dog("white coated");
        System.out.println(dog.age);
        System.out.println(dog.skinColor);
        dog.makeSound();
    }

    static void singleInheritance() {
        Cat cat = new Cat();
        System.out.println(cat.family);
        System.out.println(cat.age);
        System.out.println(cat.type);
        cat.makeSound();
    }

    static void multiLevelInheritance() {
        BabyDog babyDog = new BabyDog("black color", "only milk");
        System.out.println(babyDog.skinColor);
        System.out.println(babyDog.diet);
    }

}
