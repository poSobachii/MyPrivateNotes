package JavaBasics.a2_ClassObject.a25_NestedInnerClasses;

public class OuterClass {

    String text = "outer Class text";
    int number = 7;
    InnerClass nestedClass = new InnerClass();
    NestedStaticClass nestedStaticClass = new NestedStaticClass();

    public void accessNestedClass() {
        nestedClass.printNestedText();
        nestedStaticClass.printSomeText();
    }

    public void nestedClassDuringCodeExecution() {
        {
             class MethodNestedClass{
                String methodNestedText = text;

                public String getText(){
                    return methodNestedText;
                }
            }

            MethodNestedClass methodNestedClass = new MethodNestedClass();
            System.out.println(methodNestedClass.getText());
        }

    }

    class InnerClass {
        String innerText = "nestedText";
        int innerNumber = 666;

        public InnerClass() {
            innerText = text;
            innerNumber = number;
        }

        public void printNestedText() {
            System.out.println(innerText);
        }
    }

    static class NestedStaticClass {
        String nestedStaticText = "Some static text";
        int nestedStaticNumber = 44;

        public NestedStaticClass() {

        }

        public void printSomeText() {
            System.out.println(nestedStaticText);
        }

    }
}
