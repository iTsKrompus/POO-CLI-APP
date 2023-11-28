package upm.Data.Models;

public class Teatro extends Actividad {
    public static final double dtoJoven = 0.5;
    public static final double dtoAnciano = 0.3;
    private static final int edadJoven = 25;
    private static final int edadAnciano = 65;

    @Override
    public double aplicarDto(int edad) {
        if (edad < edadJoven) {
            setCoste(getCoste() * dtoJoven);
        } else if (edad > edadAnciano) {
            setCoste(getCoste() * dtoAnciano);
        }
        return getCoste();
    }
}

