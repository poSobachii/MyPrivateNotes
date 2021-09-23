package a1_basic_syntax;

public class ConditionsWhile {

    public static void main(String[] args) {
        doWhileStatement();
    }

    static void doWhileStatement() {
        int count = 1;
        do {
            System.out.println("will print this while 'while' conditions is true");
            count++;
        } while (count < 10);

        // cycle will iterate, while condition "(count < 10)" will be true
    }

    //todo finnally, while in front, while without do
}
