package a33_inputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {
//        readValuesFromTerminalScanner();
        readValuesFromTerminalBufferReader();
//        writeToFile();
//        readFromFile();
//        stringFormatExample();
    }

    static void readValuesFromTerminalScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type 2 words");
        String inputText = scanner.nextLine();
        System.out.println("whole line is red->" + inputText);
        System.out.println("type more then 2 words ");
        String inputWord = scanner.next();
        System.out.println("read only first word ->" + inputWord);
    }

    static void readValuesFromTerminalBufferReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("type 2 words");
        try {
            System.out.println("buffered read whole row only. use separator to separate -> " + bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("что то пошло нет так " + e);
        }
    }

    static void writeToFile() {
        File file = new File("textFiles/mytext.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("some row");
            writer.println("some another row");
            writer.println("row another some");
        } catch (IOException e) {
            System.out.println("Cannot save to file " + e);
        }
        System.out.println("Done. Check your  " + file.getAbsolutePath());
    }

    static void readFromFile() {
        File file = new File("textFiles/mytext.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println("читаем по словам - " + scanner.next());
//                System.out.println("читаем строчку - " + scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Cannot load from a file " + e);
        }
    }

    static void stringFormatExample() {
        int i = 3;
        double r = Math.sqrt(i);
        System.out.println("Корень из числа " + i + " равен " + r );
        System.out.println("Переписав тоже самое с форматом получаем:");
        System.out.format("Корень из числа %d равен %25.2f%n", i, r);
        System.out.println("Где 25 после % означает сколько сделать пробелов, " +
                "а .2 сколько чисел оставлять у дроби после запятой, %n позволяет каретке перейти на следующую строку\n" +
                "можно так же использовать \\n, это работает и в обычном тексте (не printf)");

    }


}
