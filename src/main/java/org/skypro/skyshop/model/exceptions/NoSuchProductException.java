package org.skypro.skyshop.model.exceptions;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException() {
        super("такого продукта нет");
    }

    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchProductException(Throwable cause) {
        super(cause);
    }

    public NoSuchProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
