package JavaBasics.a3_OOP.a35_Abstraction;

public class Application {

    public static void main(String[] args) {
        abstractUsage();
    }

    static void abstractUsage() {
        Command command1 = new Sleep();
        Warthog command2 = new Warthog();
        command1.defaultCommand();
        command1.specialCommand();
        command2.defaultCommand();
        command2.uniqueCommand();
        passParameter(command1);
        passParameter(command2);

        Command command3 = new Warthog();
        ((Warthog) command3).uniqueCommand();
    }

    static void passParameter(Command cmd) {
        cmd.specialCommand();
    }
}
