package JavaBasics.a2_ClassObject.a23_AccessModifiers.packageTwo;

import JavaBasics.a2_ClassObject.a23_AccessModifiers.packageOne.ProtectedField;

public class ExtendedClass extends ProtectedField {

    NoModifierClass noModifierClass = new NoModifierClass();

    public void checkMethod() {
        noModifierClass.doSmth();
    }
}
