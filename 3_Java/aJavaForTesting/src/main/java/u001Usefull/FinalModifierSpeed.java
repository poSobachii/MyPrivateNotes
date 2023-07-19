package u001Usefull;

import java.util.ArrayList;

public class FinalModifierSpeed {

    public static final int N_ITERATIONS = 10000000;

    public static String testFinal() {
        final String a = "a";
        final String b = "b";
        return a + b;
    }

    public static String testNonFinal() {
        String a = "a";
        String b = "b";
        return a + b;
    }

    public static String testInline() {
        return "ab";
    }

    public static String testInlineSumm() {
        return "a" + "b";
    }

    public static void main(String[] args) {
        long tStart, tElapsed;

        tStart = System.currentTimeMillis();
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0; i < N_ITERATIONS; i++) {
            strings1.add(testFinal());
        }
        tElapsed = System.currentTimeMillis() - tStart;
        System.out.println("Method with finals took " + tElapsed + " ms");

        ArrayList<String> strings2 = new ArrayList<>();
        tStart = System.currentTimeMillis();
        for (int i = 0; i < N_ITERATIONS; i++) {
            strings2.add(testNonFinal());
        }
        tElapsed = System.currentTimeMillis() - tStart;
        System.out.println("Method without finals took " + tElapsed + " ms");

        ArrayList<String> strings3 = new ArrayList<>();
        tStart = System.currentTimeMillis();
        for (int i = 0; i < N_ITERATIONS; i++) {
            strings3.add(testInline());
        }
        tElapsed = System.currentTimeMillis() - tStart;
        System.out.println("Method inline took " + tElapsed + " ms");

        ArrayList<String> strings4 = new ArrayList<>();
        tStart = System.currentTimeMillis();
        for (int i = 0; i < N_ITERATIONS; i++) {
            strings4.add(testInline());
        }
        tElapsed = System.currentTimeMillis() - tStart;
        System.out.println("Method inline summ took " + tElapsed + " ms");

    }
}
