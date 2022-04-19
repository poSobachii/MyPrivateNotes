package JavaBasics.a2_ClassObject.a23_AccessModifiers;

import JavaBasics.a2_ClassObject.a23_AccessModifiers.packageTwo.RegularClass;

public class WorldClass {

    public static void main(String[] args) {
        RegularClass regularClass = new RegularClass();
        System.out.println(regularClass.anotherText);
    }
}
