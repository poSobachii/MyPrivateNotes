package _1_basic_syntax;

public class VariablesString {

    public static void main(String[] args) {
//        assignStrings();
//        stringManipulation();
//        stringConversion();
//        whatIsMutableString();
    }

    static void assignStrings() {
        String string1 = "Hello!";
        char[] charArray1 = {'H', 'e', 'l', 'l', 'o', '!'};
        String string2 = new String(charArray1);                                // new string from char array
        System.out.println("string 1 equals for string 2 ? : " + string1.equals(string2));
        System.out.println("string 1 equals for string 2 ? : " + (string1 == string2));           // 'equals' and ' ==' equate differently
        String string3 = string1 + " world!";
        System.out.println("since String is immutable, to add new value, must use new variable" + string3);
    }

    static void stringManipulation() {
        String str1 = "      Hello !";
        System.out.println("method .length will get string size: " + str1.length());
        System.out.println("method .trim will remove unnecessary spaces: " + str1);
        System.out.println("trimmed : " + str1.trim());
        System.out.println();

        String str2 = "quick brown fox jumps over the lazy dog";
        System.out.println(".substring will cut the string at index " + str2.substring(15));
        System.out.println("or indexes: " + str2.substring(15, 25));

        System.out.println(".indexOf will find index of desired symbol" + str2.indexOf("i"));
        System.out.println("will be -1 if no such" + str2.indexOf("?"));

        String string4 = "i've@become@so numb@i can@feel@you there";
        String[] stringArray1 = string4.split("@", 3);
        for (String x : stringArray1) {
            System.out.println(x);
        }

        String string5 = "Hello world";
        String string6 = string5.replaceAll("world", "hell");
        System.out.println("it was: " + string5 + " , it is  now: " + string6);
    }

    static void stringConversion() {
        int int1 = 1;
        double double1 = 1.1;
        String stringFromInt = String.valueOf(int1);
        String stringFromDouble = String.valueOf(double1);
        System.out.println("these have type - String  " + stringFromInt + ", " + stringFromDouble);

        String longString = "10";
        String doubleString = "1.1";
        int newInt1 = Integer.parseInt(longString);
        double newDouble1 = Double.parseDouble(doubleString);
        System.out.println("now " + newInt1 + " и " + newDouble1 + " are int and double by type, not String");
    }


    static void whatIsMutableString() {
        int int1  = 10;
        int1 +=15;
        System.out.println("we can add to existing int and get: " + int1 + " Cant do the same with String ->");
        String str1 = "hello";
        str1.concat(" world");
        System.out.println("nothing will happen since String is immutable and can be concated to the same var: " + str1);
        String str2 = str1.concat(" world");
        System.out.println("with reassigned var we can concat it: " + str2);
    }
}
