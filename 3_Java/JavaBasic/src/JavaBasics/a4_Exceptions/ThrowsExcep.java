package JavaBasics.a4_Exceptions;

import java.io.*;
import java.util.Scanner;

public class ThrowsExcep {

    public static void main(String args[]) {
//        NPEcrashProgram();
//        NPEcrashWithTry();
//        finallyOperatorWithoutException();
//        finallyOperatorWithException();
//        multipleExceptionSingleBlock();
//        multipleExceptionSeparateBlocks();
//        catchExceptionFromAnotherMethod();
//        creatingAndCatchingCustomException();
//        errorExample(5);
//        tryCatchWithResources();
    }

    private static void tryCatchWithResources() {
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            writer.print(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader inputString = new StringReader("HoLyWaR");
        BufferedReader br = new BufferedReader(inputString);
        try (br) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finished !");
    }

    private static void errorExample(int i) {
        if (i == 0) {
        } else {
            errorExample(i++);
        }
    }

    static void NPEcrashProgram() {
        String str = null;
        System.out.println(str.length());
    }

    static void NPEcrashWithTry() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("we catch it " + e);
        }
        System.out.println("Hello world");
    }

    static void finallyOperatorWithoutException() {
        try {
            System.out.println("Try was complete");
        } catch (NullPointerException e) {
            System.out.println("exception worked out " + e);
        } finally {
            System.out.println("Hello Finally");
        }
    }

    static void finallyOperatorWithException() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("exception worked out " + e);
        } finally {
            System.out.println("Hello Finally");
        }
    }

    static void multipleExceptionSingleBlock() {
        for (int i = 0; i < 2; i++) {
            try {
                if(i==0) {
                    String str = null;
                    System.out.println(str.length());
                } else {
                    int number = 10 / 0;
                }
            } catch (NullPointerException | ArithmeticException e) {
                System.out.println("Exception catched " + e);
            }
        }
    }

    static void multipleExceptionSeparateBlocks() {
        for (int i = 0; i < 2; i++) {
            try {
                if(i==0) {
                    String str = null;
                    System.out.println(str.length());
                } else {
                    int number = 10 / 0;
                }
            } catch (NullPointerException e) {
                System.out.println("1 block of exception" + e);
            } catch (ArithmeticException e){
                System.out.println("2 block of exception " + e);
            }
        }
    }

    static  void catchExceptionFromAnotherMethod(){
        try {
            int result = methodThrowsException();
        } catch (ArithmeticException e){
            System.out.println("Exception -> " + e);
        }
    }

    static int methodThrowsException() throws ArithmeticException{
        return 10/0;
    }

    static void creatingAndCatchingCustomException(){
        try {
            methodThrowsCustomException();
        } catch (SomeCustomException e) {
            System.out.println("Exception -> " + e);
        }
        methodThrowsCustomException();
    }

    static void methodThrowsCustomException(){
        if (true){
            throw new SomeCustomException("Hello custom exception", 666);
        }

    }
}


