package JavaBasics.a2_ClassObject.a23_AccessModifiers.packageOne;

import JavaBasics.a2_ClassObject.a23_AccessModifiers.packageTwo.ExtendedClass;
import JavaBasics.a2_ClassObject.a23_AccessModifiers.packageTwo.RegularClass;

public class Application {
    public static void main(String[] args) {
        publicModifier();
        privateModifier();
        protectedModifier();
    }

    private static void publicModifier() {
        RegularClass regularClass = new RegularClass();
        System.out.println(regularClass.anotherText);
    }

    private static void privateModifier() {
        NonPublicClass nonPublicClass = new NonPublicClass();
        nonPublicClass.setText("replaced text in private field");
        System.out.println(nonPublicClass.getText());
    }

    private static void protectedModifier() {
        ProtectedField protectedField = new ProtectedField();
        System.out.println(protectedField.anotherText);
        System.out.println(protectedField.noText);

        ExtendedClass extendedClass = new ExtendedClass();
        extendedClass.checkMethod();
        System.out.println(extendedClass.anotherText);
    }
}
