package JavaBasics.a5_Arrays_and_Collections.a52_Arrays;

import JavaBasics.a5_Arrays_and_Collections.Plane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysExample {

    public static void main(String[] args) {
//        arrayInitializing();
//        multidimensionalArrays();
        arrayManipulation();
//        arrayOfObjects();
    }

    static void arrayInitializing() {
        String[] stringArray1 = new String[3];                              // array defined with TYPE and SIZE
        String[] stringArray2 = {"Dog", "Cat", "Bird"};                     // array defined with values
        System.out.println("Second value " + stringArray2[1]);
        System.out.println("null " + Arrays.toString(stringArray1));
        System.out.println("values " + Arrays.toString(stringArray2));
        System.out.println("size of array " + stringArray2.length);

        int[] intArray1 = new int[6];
        System.out.println("int default is 0 ->" + Arrays.toString(intArray1));
        Arrays.fill(intArray1, 10);     // fill array with default value
        System.out.println("filled arrays values ->" + Arrays.toString(intArray1));

        intArray1[3] = 34;                  // replace value in array at index 3
        System.out.println("replace specific value" + Arrays.toString(intArray1));

        int[] intArray2 = {2, 3, 4, 5, 6, 7};               // another way to initialize int array with values
        System.out.println("values: " + Arrays.toString(intArray2));
    }

    static void multidimensionalArrays() {
        int[][] intMultidimensionalArray = {
                {1, 2, 3},
                {4, 5, 6}
        };
        // fetching data for multidimensional array need to specify [which array] [target index]
        System.out.println("3. value from first array: " + intMultidimensionalArray[0][2]);
        System.out.println("2. values from second array: " + intMultidimensionalArray[1][1]);

        int[][] multiArray = { {1, 2, 3, 4}, {5, 6, 7} };
        for (int[] oneArray : multiArray) {
            for (int number : oneArray) {
                System.out.println(number);
            }
        }
    }

    static void arrayManipulation() {
        int[] intArray1 = {1, 2, 3};
        int[] intArray2 = {1, 2, 3};
        int[] intArray3 = {3, 2, 1};
        System.out.println("array 1 same as array 2 ?: " + Arrays.equals(intArray1, intArray2));
        System.out.println("array 1 same as array 3 ?: " + Arrays.equals(intArray1, intArray3));
        System.out.println("array 1 same as array 2 ?: " + (intArray1 == intArray2));
        System.out.println("array 1 same as array 3 ?: " + (intArray1 == intArray3));

        char[] charArray1 = {'d', 'e', 'j', 'a', 'v', 'a', 'e', 'i', 'n', 'a', 't', 'e', 'd'};
        char[] charArray2 = new char[7];
        System.arraycopy(charArray1, 2, charArray2, 0, 4);           // copy starting index 2 to destination position 0 index , and length for 4

        System.out.println("copy result: " + Arrays.toString(charArray2));

        int[] intArray4 = {7, 4, 9, 1, 2, 8};
        int[] intArray5 = new int[6];
        Arrays.fill(intArray4, 10);
        Arrays.fill(intArray5, 10);
        System.out.println("Method .fill replaces all values: " + Arrays.toString(intArray4) + " , " + Arrays.toString(intArray5));

        int[] intArray6 = {7, 4, 9, 1, 2, 8};
        Arrays.sort(intArray6);
        Integer[] intArray62 = {7, 4, 9, 1, 2, 8};
        Arrays.sort(intArray62, Collections.reverseOrder());
        System.out.println("sorted" + Arrays.toString(intArray6));
        System.out.println("reverseSorted doesnt work for primitive" + Arrays.toString(intArray2));             // for primitives should write custom comparator


        int[] intArray7 = {12, 13, 14, 15, 16, 17, 18};
        int[] intArray8 = Arrays.copyOf(intArray7, 9);
        System.out.println("method .copy will copy all available values and add the missed with default values" + Arrays.toString(intArray8));
        int[] intArray9 = Arrays.copyOfRange(intArray7, 2, 4);
        System.out.println("method .copyOfRange will copy selected range by index " + Arrays.toString(intArray9));


        int[] intArray10 = {15, 14, 13, 12, 16, 17, 20};
        Arrays.sort(intArray10);
        System.out.println("15 is place at " + Arrays.binarySearch(intArray10, 15));
        System.out.println("15 find ? " + Arrays.binarySearch(intArray10, 0, 2, 15));
        System.out.println("15 is place at " + Arrays.binarySearch(intArray10, 15));
        System.out.println("5 is place at " + Arrays.binarySearch(intArray10, 5));
        System.out.println("100 is place at " + Arrays.binarySearch(intArray10, 100));
        System.out.println("20 is place at " + Arrays.binarySearch(intArray10, 20));
        System.out.println("19 is place at " + Arrays.binarySearch(intArray10, 19));

    }

    static void arrayOfObjects() {
        Plane pl1 = new Plane("Boeing", 20);
        Plane pl2 = new Plane("Airbus", 15);
        Plane pl3 = new Plane("Bombardier", 3);
        Plane[] planes = {pl1, pl2, pl3};
        for ( Plane pl: planes) {
            System.out.println(pl);                         // covert objects to text @override to string required
        }
        System.out.println(planes.toString());

        List<Plane> planeList = Arrays.asList(planes);
        System.out.println("list of same values: " + planeList);

    }
}
