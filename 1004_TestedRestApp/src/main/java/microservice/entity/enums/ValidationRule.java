package microservice.entity.enums;

public enum ValidationRule {

    CUSTOMER_EMAIL(1, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", "Email must contains @ and web address"),
    CARD_EXPIRATION_DATE(2, "^(0[1-9]|1[0-2])\\/?([0-9]{4}|[0-9]{2})$", "Incorrect date format, must be '00/00' type");


    ValidationRule(int id, String regex, String message) {
        this.id = id;
        this.regex = regex;
        this.message = message;
    }

    private final int id;
    private final String regex;
    private final String message;

    public int getId() {
        return id;
    }

    public String getRegex() {
        return regex;
    }

    public String getMessage() {
        return message;
    }
}
