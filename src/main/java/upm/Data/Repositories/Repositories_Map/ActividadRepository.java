package upm.Data.Repositories.Repositories_Map;

import upm.Data.Models.Actividad;

public class ActividadRepository extends GenericRepository<Actividad> {
    @Override
    protected void setId(Actividad act, Integer id) {
        act.setId(id);
    }

    @Override
    protected int getId(Actividad act) {
        return act.getId();
    }
}
