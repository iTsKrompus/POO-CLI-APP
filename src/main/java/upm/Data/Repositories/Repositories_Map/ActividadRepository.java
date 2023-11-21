package upm.Data.Repositories.Repositories_Map;

import upm.Data.Models.Actividad;
import upm.Data.Repositories.ActividadRepositoryInterface;

public class ActividadRepository extends GenericRepository<Actividad> implements ActividadRepositoryInterface {
    @Override
    protected void setId(Actividad act, Integer id) {
        act.setId(id);
    }

    @Override
    protected Integer getId(Actividad act) {
        return act.getId();
    }
}

