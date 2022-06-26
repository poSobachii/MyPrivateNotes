package JavaBasics.a1_BasicSyntax;

public class a16_Statements {

    public static void main(String[] args) {
//        ifElseStatement();
//        ternaryOperators();
//        switchStatement();
        operatorPrecedence();
    }

    private static void operatorPrecedence() {
        boolean statement1 = true;
        boolean statement2 = true;
        boolean statement3 = false;
        boolean statement4 = false;
        if (statement1 && statement2 || statement3) {
            System.out.println("hello world - 1");
        }
        if ((statement1 && statement2) || statement3) {
            System.out.println("hello world - 2");
        }
        if (statement1 && (statement2 || statement3)) {
            System.out.println("hello world - 3");
        }
        if (statement1 && statement2 || statement3 && statement4) {
            System.out.println("hello world - 4");
        }
        if (statement1 && (statement2 || statement3) && statement4) {
            System.out.println("hello world - 5");
        }
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

    static void switchStatement() {
        int expression = 2;
        switch (expression) {
            case 1: System.out.println("case 1 inv.");
            case 2: System.out.println("case 2 inv.");
            case 3: System.out.println("case 3 inv.");
                break;                                        // break needs to exit switch statement
            default: System.out.println("default inv.");      // default will be invoked if there was no case for checked expression. Without default exceptions might occure
        }
        System.out.println("case 2 & 3 was invoked since there was no 'break' after case 2 executed");

        int expression2 = 6;
        switch (expression2) {
            case 1: System.out.println("case 1 inv.");
            case 2: System.out.println("case 2 inv.");
            case 3: System.out.println("case 3 inv.");
                break;
            default: System.out.println("for all non-handled expressions - default statement will be invoked");
        }
    }


  /*
    java 17 switch looks like this

    static String getInt(int requestId){
        String response  = switch(requestId) {
            case 1, 2, 3, 4, 5 -> "Working day";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println(response);
        return response;
    }
    */
}
