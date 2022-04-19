package JavaBasics.a2_ClassObject.a25_NestedInnerClasses;

public class Application {
    public static void main(String[] args) {
        nestedClasses();
//        methodNestedClass();
//        moreThanOneClass();
    }

    private static void moreThanOneClass() {
        HorrorBook horrorBook = new HorrorBook();
        AdventureBook adventureBook = new AdventureBook();
        horrorBook.printTitle();
        adventureBook.printTitle();
    }

    private static void methodNestedClass() {
        OuterClass regularClass = new OuterClass();
        regularClass.nestedClassDuringCodeExecution();

    }

    private static void nestedClasses() {
        OuterClass regularClass = new OuterClass();
        regularClass.accessNestedClass();

        OuterClass.NestedStaticClass nestedStaticClass = new OuterClass.NestedStaticClass();
        nestedStaticClass.printSomeText();
    }
}
