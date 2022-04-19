package JavaBasics.a3_OOP.a35_Abstraction;

public class Warthog extends Command{

    @Override
    void specialCommand() {
        System.out.println("Warthog goes brrrrrrrrrrr....");
    }

    void uniqueCommand() {
        System.out.println("Ha-ha-ha WARTHOG so powerful....");
    }
}
