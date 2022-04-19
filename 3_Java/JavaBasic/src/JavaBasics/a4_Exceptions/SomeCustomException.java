package JavaBasics.a4_Exceptions;

class SomeCustomException extends RuntimeException {

    public SomeCustomException(String message, int code){
        super(message);
        System.out.println("We can add logic for exception here with " + code);
    }
}
