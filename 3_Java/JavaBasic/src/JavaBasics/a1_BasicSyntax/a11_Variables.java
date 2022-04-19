package JavaBasics.a1_BasicSyntax;

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
        int number = 100;
        long longNumber = 100L;
        float smallDecimal = 10.00f;
        double bigDecimal = 10.00;
        boolean bool = true;

        System.out.println(text);
    }

    static void variableAccess() {
        System.out.println("global variables / field are usable anywhere according access modifiers -> " + globalVar);
        System.out.println("local variables are only sued inisde declared method, we can use here 'localVar' declared in 'someMethod' below");
    }


    static void someMethod() {
        int localVar = 55;
    }
}
