package JavaBasics.a1_BasicSyntax;

import java.math.BigDecimal;
import java.math.BigInteger;

public class a11_Variables {

    private static int globalVar = 100;            // called as field

    public static void main(String[] args) {
        variableTypes();
        implicitCasting();
        explicitCasting();
        variableAccess();
        primitiveDiffToObject();
    }

    static void primitiveDiffToObject() {
        int primitiveInt = 100;
        Integer objectInt = 100;
        System.out.println(objectInt.intValue());
        System.out.println(objectInt.hashCode());
    }

    static void explicitCasting() {
        long longVal = 100L;
        int intVal = (int) longVal;
        System.out.println(intVal);
    }

    static void implicitCasting() {
        int intVal = 100;
        long longVal = intVal;
        System.out.println(longVal);
    }

    static void variableTypes() {
        byte b = -128;
        byte b2 = 127;
        char letter = 'a';
        String text = "Just a text";
        int n1 = 2147483647;
        long l1 = 9223372036854775807L;
        float f1 = 10.123456789f;             // will round
        double d1 = 101.1234567890123456789;        // 16 digits max.  will error
        boolean bool = true;
        BigInteger bi = new BigInteger("9223372036854775808");
        BigDecimal bd = new BigDecimal("101.1234567890123456789012345");


        System.out.println(text);
    }

    static void variableAccess() {
        System.out.println("global variables / field are usable anywhere according access modifiers -> " + globalVar);
        System.out.println("local variables are only used inside declared method, we can't use here 'localVar' declared in 'someMethod' below");
    }


    static void someMethod() {
        int localVar = 55;
    }
}
