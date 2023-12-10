package upm.Data.Models;

import java.time.Duration;

public interface ActividadBuilder { //Pendiente
    interface Tipo {
        Nombre tipo(String tipo);

    }

    interface Nombre {
        Descripcion nombre(String nombre);
    }

    interface Descripcion {
        Duracion despcripcion(String descripcion);
    }

    interface Duracion {
        Coste duracion(Duration duracion);
    }

    interface Coste {
        Optionals coste(Double coste);
    }

    interface Optionals {
        Optionals aforo(int aforo);

        Actividad build();
    }
}

