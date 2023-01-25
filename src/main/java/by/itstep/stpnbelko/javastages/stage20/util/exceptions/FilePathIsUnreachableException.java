package by.itstep.stpnbelko.javastages.stage20.util.exceptions;

public class FilePathIsUnreachableException extends TechnicalException{
    public FilePathIsUnreachableException() {
        super();
    }

    public FilePathIsUnreachableException(String message) {
        super(message);
    }

    public FilePathIsUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilePathIsUnreachableException(Throwable cause) {
        super(cause);
    }
}
