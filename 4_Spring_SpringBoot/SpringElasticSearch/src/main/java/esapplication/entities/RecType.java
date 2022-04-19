package esapplication.entities;

public enum RecType {

    DOG("DOG"),
    CAT("CAT"),
    BIRD("BIRD");

    String type;

    RecType(String type) {
        this.type = type;
    }
}
