package JavaBasics.a3_OOP.a33_Inheritance;

public class BabyDog extends Dog {
    String diet;

    BabyDog(String skinColor, String diet) {
        super(skinColor);
        this.diet = diet;
    }
}
