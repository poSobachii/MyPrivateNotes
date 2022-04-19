package JavaBasics.a2_ClassObject.a24_StaticFinal;

public class Application {

    public static void main(String[] args) {
        finalField();
        staticField();
    }

    private static void staticField() {
        RegularClass regularClass = new RegularClass("Hello world");
        System.out.println("Text -> " + regularClass.text);
        System.out.println("Number -> " + regularClass.number);
        System.out.println("Counter -> " + regularClass.getCount());

        RegularClass regularClass2 = new RegularClass("Bye hell");
        System.out.println("Text -> " + regularClass2.text);
        System.out.println("Number -> " + regularClass2.number);
        System.out.println("Counter -> " + regularClass2.getCount());

        System.out.println("Current counter -> " + RegularClass.COUNT);
    }

    private static void finalField() {
        RegularClass regularClass = new RegularClass("Hello world");
        System.out.println(regularClass.FINAL_TEXT);
    }
}
