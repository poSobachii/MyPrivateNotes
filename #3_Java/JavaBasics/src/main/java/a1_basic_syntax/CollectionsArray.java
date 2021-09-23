package a1_basic_syntax;

import java.util.Arrays;

public class CollectionsArray {

    public static void main(String[] args) {
//            arrayInitializing();
//            multidimensionalArrays();
        arrayManipulation();
    }

    static void arrayInitializing() {
        String[] stringArray1 = new String[3];                              // array defined with TYPE and SIZE
        String[] stringArray2 = {"Dog", "Cat", "Bird"};                     // array defined with values
        System.out.println("we will get 3 null as we didnt inserted values: " + java.util.Arrays.toString(stringArray1));
        System.out.println("compared to initialized array with values at once: " + java.util.Arrays.toString(stringArray2));

        int[] intArray1 = new int[6];
        System.out.println("default values for int = 0: " + java.util.Arrays.toString(intArray1));
        java.util.Arrays.fill(intArray1, 10);     // fill array with default value
        System.out.println("filled arrays with default vaues: " + java.util.Arrays.toString(intArray1));

        intArray1[3] = 34;                  // replace value in array at index 3
        System.out.println("can swap value by index, number 4 have index 3: " + java.util.Arrays.toString(intArray1));

        int[] intArray2 = {2, 3, 4, 5, 6, 7};               // another way to initialize int array with values
        System.out.println("initialized int array with values: " + java.util.Arrays.toString(intArray2));
    }

    static void multidimensionalArrays() {
        int[][] intMultidimensionalArray = {
                {1, 2, 3},
                {4, 5, 6}
        };
        // fetching data for multidimensional array need to specify [which array] [target index]
        System.out.println("3. value from first array: " + intMultidimensionalArray[0][2]);
        System.out.println("2. values from second array: " + intMultidimensionalArray[1][1]);
    }

    static void arrayManipulation() {
        int[] intArray1 = {1, 2, 3};
        int[] intArray2 = {1, 2, 3};
        int[] intArray3 = {3, 2, 1};
        System.out.println("array 1 same as array 2 ?: " + Arrays.equals(intArray1, intArray2));
        System.out.println("array 1 same as array 3 ?: " + Arrays.equals(intArray1, intArray3));
        System.out.println();

        char[] charArray1 = {'d', 'e', 'j', 'a', 'v', 'a', 'e', 'i', 'n', 'a', 't', 'e', 'd'};
        char[] charArray2 = new char[7];
        System.arraycopy(charArray1, 2, charArray2, 0, 4);           // copy starting index 2 to destination position 0 index , and length for 4

        System.out.println("copy result: " + Arrays.toString(charArray2));
        System.out.println();

        int[] intArray4 = {7, 4, 9, 1, 2, 8};
        int[] intArray5 = new int[6];
        Arrays.fill(intArray4, 10);
        Arrays.fill(intArray5, 10);
        System.out.println("Method .fill replaces all values: " + Arrays.toString(intArray4) + " , " + Arrays.toString(intArray5));
        System.out.println();

        int[] intArray6 = {7, 4, 9, 1, 2, 8};
        Arrays.sort(intArray6);
        System.out.println("Method .sort will sort the array" + Arrays.toString(intArray6));
        System.out.println();


        int[] intArray7 = {12, 13, 14, 15, 16, 17, 18};
        int[] intArray8 = Arrays.copyOf(intArray7, 9);
        System.out.println("method .copy will copy all available values and add the missed with default values" + Arrays.toString(intArray8));

        int[] intArray9 = Arrays.copyOfRange(intArray7, 2, 4);
        System.out.println("method .copyOfRange will copy selected range by index " + Arrays.toString(intArray9));
    }
}
