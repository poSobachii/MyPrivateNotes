package JavaBasics.a1_BasicSyntax;

public class a17_Loop {

    public static void main(String[] args) {
        forStatement();
        foriStatement();
        whileDoStatement();
        doWhileStatement();
        breakStatement();
        continueStatement();
    }

    // foreach
    static void forStatement() {
        int[] marks = {125, 132, 95, 116, 110};
        int maxSoFar = marks[0];
        for (int num : marks) {
            if (num > maxSoFar) {
                maxSoFar = num;
            }
        }

        System.out.println("The highest mark -> " + maxSoFar);
    }

    static void foriStatement() {
        int[] marks = {125, 132, 95, 116, 110};
        int highestMark = 0;
        for (int i = 0; i < marks.length; i++) {
            int currentMark = marks[i];
            if(currentMark > highestMark) {
                highestMark = currentMark;
            }
        }

        System.out.println("The highest mark -> " + highestMark);
    }

    static void whileDoStatement() {
        int count = 1;
        while (count != 5) {
            System.out.println("current count -> " + count);
            count++;
        }

        while (count > 10) {
            System.out.println("unreachable code");
        }
        System.out.println("The END");
    }

    static void doWhileStatement() {
        int count = 1;
        do {
            System.out.println("current count -> " + count);
            count++;
        } while (count != 5);

        do {
            System.out.println("at least once it was executed");
        } while (count > 10);
        System.out.println("The END");

    }

    static void breakStatement() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Current index = " + i);
            if (i ==6) {
                break;
            }
        }
    }

    static void continueStatement() {
        for (int i = 0; i < 10; i++) {
            if(i == 5 || i == 6) {
                continue;
            }
            System.out.println("Current index = " + i);
        }
    }

}
