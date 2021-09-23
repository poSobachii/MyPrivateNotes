package a1_basic_syntax;

public class VariablesDeclaration {

    static String fieldVar1 = " #some GLOBAL string#";              // global variable = field
    static String fieldVar2;                                        // global var without value
    static final String finalFieldVar3 = "final GLOBAL variable";       // final global variable cannot be overwritten or declared without value
    static final String finalFieldVar4 = null;

    public static void main(String[] args) {
        declareVariables();
        variableCasting();
    }

    static void declareVariables() {
        String localVar1 = "#some local variable#";                     // local variable used only in this method
        int localVar2 = 5;
        int localVar3;                                  // declare var without value
        localVar3 = 3;                                  // assign new value to var
        long localVar4 = 10L;                           // sometimes type must be defined also.

        System.out.println("this method can use local defined variables: " + localVar1);
        System.out.println("this method can use global vars: " + fieldVar1);
        System.out.println("there will be null value for undefined variables: " + fieldVar2);
        fieldVar2 = "#some NEW text assigned to GLOBAL var#";
        System.out.println("we can reassign values for global non-final field any time f.e: " + fieldVar2);
    }

    static void variableCasting() {
        byte byt = 50;
        int int1 = byt;                                 // casting from lower type to higher no type define required
        System.out.println("we had byte with value: " + byt);
        System.out.println("casted to int type and got:  " + int1);

        long long1 = 100;
        int int2 = (int) long1;                         // casting from higher to lower, explicit type definition required
        System.out.println("we had long with value " + long1 + ", casted to int and got the same value: " + int2);
    }

}
