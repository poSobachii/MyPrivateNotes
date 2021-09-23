package a1_basic_syntax;

public class ConditionsIfElse {

    public static void main(String[] args) {
        ifElseStatement();
        ternaryOperators();
    }

    static void ifElseStatement() {
        boolean boolean1 = true;
        boolean boolean2 = false;
        if (boolean1) {
            System.out.println("checkpoint #1 as boolean1 is true");
        }
        if (boolean2) {
            System.out.println("checkpoint #2");           // but it will not be printed since boolean2 is false
        } else {
            System.out.println("checkpoint #3 since boolean2 is false, we got here as 'else' statement");
        }

        if (boolean2) {
            System.out.println("checkpoint #4");
        } else if (boolean1) {                          // this will be checked if previous If was false
            System.out.println("checkpoint #5");
        }

        if (boolean1) {
            System.out.println("checkpoint #6");
        } else if (boolean1) {                          // since first If was true - we don't check this one
            System.out.println("checkpoint #7");
        }
    }

    static void ternaryOperators() {
        boolean b1 = true;

        // ternary operators helps to inline your code. Following statement written with ternary operator below
        if (b1) {
            System.out.println("Hello If");
        } else {
            System.out.println("Hello else");
        }

        System.out.println(b1 ? "Hello if" : "Hello else");
        System.out.println(!b1 ? "Hello if" : "Hello else");
    }
}
