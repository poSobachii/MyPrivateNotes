package JavaBasics.a1_BasicSyntax;

public class a12_Functions {

    public static void main(String[] args) {
        voidMethodNoParameters();
        voidMethodWithParameters("Text to sent into method");
        methodWithReturnValue();
    }

    static void voidMethodWithParameters(String inputText) {
        System.out.println("input parameters -> " + inputText);
    }

    static void voidMethodNoParameters() {
        int x = 10;
        int y = 15;
        int sum = x + y;
        System.out.println("The sum " + sum);
        System.out.println("The sum " + (x +y));
    }

    static void methodWithReturnValue() {
        String answer = getAnswer();
        System.out.println("retuned value -> " + answer);
        System.out.println("retuned value -> " + getAnswer());
    }

    static String getAnswer() {
        return "Hello Return";
    }
}
