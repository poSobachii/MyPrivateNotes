package JavaBasics.a3_OOP.a35_Abstraction;

public abstract class Command {

    void defaultCommand() {
        System.out.println("We just wondering around .....");
    }

    abstract void specialCommand();
}
