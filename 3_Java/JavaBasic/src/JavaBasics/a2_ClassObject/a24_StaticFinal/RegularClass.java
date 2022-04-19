package JavaBasics.a2_ClassObject.a24_StaticFinal;

public class RegularClass {

    public String text;
    public int number = 0;
    public static int COUNT = 0;
    public final String FINAL_TEXT = "You can CHANGE this !";

    RegularClass(String text) {
        this.text = text;
        number++;
        COUNT++;
    }

    public int getCount() {
       return COUNT;
    }
}
