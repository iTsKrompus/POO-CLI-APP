package upm.Services;

public class InvalidDateException extends RuntimeException{
    private static final String DESCRIPTION = "Invalid Date Exception. Fecha en un rango incorrecto";
    public InvalidDateException (String text){
        super(DESCRIPTION + " >>>> " + text);
    }
}
