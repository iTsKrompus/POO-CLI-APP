package upm;

public class InvalidAtributeException extends RuntimeException {
    private static final String DESCRIPTION = "Invalid Atribute Exception. Atributo con valor no permitido";

    public InvalidAtributeException(String text) {
        super(DESCRIPTION + " >>>> " + text);
    }
}

