package a1_basic_syntax;

public class ConditionsSwitch {

    public static void main(String[] args) {
        switchStatement();
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
}
