package microservice.service.validation.pojo;


public class WrongInputFormatException extends Exception {
    public WrongInputFormatException(String errorMessage) {
        super(errorMessage);
    }
}

