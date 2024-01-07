package upm;

public class InvalidObjectException extends RuntimeException{
    private static final String DESCRIPTION = "Invalid Object Exception. Objeto inesperado";
    public InvalidObjectException (String text){
        super(DESCRIPTION + " >>>> " + text);
    }
}
