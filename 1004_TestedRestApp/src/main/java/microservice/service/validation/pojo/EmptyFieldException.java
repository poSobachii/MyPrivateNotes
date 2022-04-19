package microservice.service.validation.pojo;

public class EmptyFieldException extends Exception {
    public EmptyFieldException() {
        super("Fields cant be empty");
    }
}
