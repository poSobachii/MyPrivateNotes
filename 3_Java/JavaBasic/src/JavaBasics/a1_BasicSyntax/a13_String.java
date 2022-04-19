package JavaBasics.a1_BasicSyntax;

public class a13_String {
    public static void main(String[] args) {
//        assignStrings();
//        equalsVsHashCode();
//        stringManipulation();
//        stringConversion();
//        whatIsMutableString();
        printFormat();
    }

    static void assignStrings() {
        String string1 = "Hello!";
        char[] charArray1 = {'H', 'e', 'l', 'l', 'o', '!'};
        String string2 = new String(charArray1);
        System.out.println("completed string -> " + string2);
        String string3 = string1 + " world!";
        System.out.println("string may be reassigned with new string only" + string3);
    }

    static void equalsVsHashCode() {
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

        int x = 4;
        int y = 4;
        Integer nx = 4;
        Integer ny = new Integer(4);
        System.out.println(x == y);
        System.out.println(nx == ny);
        System.out.println(nx.equals(ny));

    }

    static void stringManipulation() {
        String str1 = "      Hello !";
        System.out.println("length -> " + str1.length());
        System.out.println("trim spaces : " + str1.trim());

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
        Integer int1  = 10;
        int1 +=15;
        System.out.println("we can add to existing int and get: " + int1 + " Cant do the same with String ->");
        String str1 = "hello";
        str1.concat(" world");
        System.out.println("nothing will happen since String is immutable and can be concated to the same var: " + str1);
        str1 = str1.concat(" world");
        System.out.println("with reassigned var we can concat it: " + str1);
    }

    static void printFormat() {
        String st1 = "World";
        int number = 5;
        System.out.printf("Hello %s at age -> %d", st1, number);
    }


    //      %d – for signed decimal integer
    //      %f – for the floating point
    //      %o – octal number
    //      %c – for a character
    //      %s – a string
    //      %i – use for integer base 10
    //      %u – for unsigned decimal number
    //      %x – hexadecimal number
    //      %% – for writing % (percentage)
    //      %n – for new line = \n

}
