package JavaBasics.a2_ClassObject.a22_Constructors;

public class Application {

    public static void main(String[] args) {
        defaultConstructor();
        parameterizedConstructor();
        overloadedConstructor();
    }

    private static void overloadedConstructor() {
        OverloadedConstructor overloadedConstructor1 = new OverloadedConstructor();
        overloadedConstructor1.text = "Hello to overload";
        System.out.println(overloadedConstructor1.text);

        OverloadedConstructor overloadedConstructor2 = new OverloadedConstructor("ParamText");
        System.out.println(overloadedConstructor2.text + " " + overloadedConstructor2.number);

        OverloadedConstructor overloadedConstructor3 = new OverloadedConstructor("Another Param text", 666);
        System.out.println(overloadedConstructor3.text + " " + overloadedConstructor3.number);
    }

    private static void parameterizedConstructor() {
        ParameterizedConstructor parameterizedConstructor = new ParameterizedConstructor("Good bye my friend");
        System.out.println(parameterizedConstructor.text);
    }

    private static void defaultConstructor() {
        DefaultConstructor defaultConstructor = new DefaultConstructor();
        defaultConstructor.text = "Hello my Friend";
        System.out.println(defaultConstructor.text);
    }
}
