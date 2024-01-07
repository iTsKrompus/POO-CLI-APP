package upm.Console;

public class InvalidValuesException extends RuntimeException {
    private static final String DESCRIPTION = "Invalid Values Exception. Numero erroneo de valores";

    public InvalidValuesException(String text) {
        super(DESCRIPTION + " >>>> " + text);
    }
}
