@SuppressWarnings("serial")
public class NumeralSystemException extends RuntimeException {
	
	public NumeralSystemException() {
        super();
    }

    public NumeralSystemException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NumeralSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumeralSystemException(String message) {
        super(message);
    }

    public NumeralSystemException(Throwable cause) {
        super(cause);
    }

}
