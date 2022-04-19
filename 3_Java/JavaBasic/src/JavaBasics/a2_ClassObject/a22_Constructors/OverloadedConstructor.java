package JavaBasics.a2_ClassObject.a22_Constructors;

public class OverloadedConstructor {
    String text;
    int number;

    public OverloadedConstructor() {
    }

    public OverloadedConstructor(String text) {
        this.text = text;
    }

    public OverloadedConstructor(String text, int number) {
        this.text = text;
        this.number = number;
    }
}
