package JavaBasics.a2_ClassObject.a21_ClassInitialization;

public class Application {

    public static void main(String[] args) {
        singleObjectInit();
        objectInsideObject();
    }

    private static void objectInsideObject() {
        Animal dog = new Animal();
        dog.type = "Dog";
        dog.sound = "bark";

        ZooPark zoo = new ZooPark();
        zoo.animal = dog;
        zoo.someZooAction();

        Animal bird = new Animal();
        bird.type = "Bird";
        bird.sound = "blow my whistle";
        zoo.animal = bird;
        zoo.someZooAction();

    }

    private static void singleObjectInit() {
        Animal cat = new Animal();
        cat.type = "Cat";
        cat.makeSound();
        cat.sound = "meow";
        cat.makeSound();
    }
}
