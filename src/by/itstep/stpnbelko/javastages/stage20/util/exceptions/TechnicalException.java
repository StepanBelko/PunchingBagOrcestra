package by.itstep.stpnbelko.javastages.stage20.util.exceptions;

public class TechnicalException extends PunchingBagOrchestraException {
    public TechnicalException() {
        super();
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }
}
