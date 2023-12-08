package upm.Console;

public class View {

    public static final String COMMAND = "gps>";

    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";


    public static final String BACKGROUND_RED = "\u001B[41m";

    public void show(String message){
        System.out.println(View.BLUE +" " + message + " " + View.RESET);
    }
    public void showBold(String message){
        System.out.println((View.PURPLE + " " + message + " " + View.RESET));
    }
    public void showError(String message){
        System.out.println(BACKGROUND_RED + View.BLACK + " " + message + " " + View.RESET);
    }
    public void showCommand(){
        System.out.print(COMMAND);
    }

}
