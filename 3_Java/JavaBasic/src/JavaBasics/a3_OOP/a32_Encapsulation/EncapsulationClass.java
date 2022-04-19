package JavaBasics.a3_OOP.a32_Encapsulation;

public class EncapsulationClass {

    private String text;
    private int number;

    EncapsulationClass(String text, int number) {
        this.text = text;
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private void printFields() {
        System.out.println("Text -> " + text + ", number -> " + number);
    }

}
