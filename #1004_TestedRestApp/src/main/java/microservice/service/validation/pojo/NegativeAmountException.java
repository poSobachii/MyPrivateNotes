package microservice.service.validation.pojo;

public class NegativeAmountException extends Exception {
    public NegativeAmountException() {
        super("Amount can't be negative");
    }
}
