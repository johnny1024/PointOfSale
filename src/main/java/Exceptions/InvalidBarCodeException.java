package Exceptions;

public class InvalidBarCodeException extends Exception{
    public InvalidBarCodeException(String message) {
        super(message);
    }
}
