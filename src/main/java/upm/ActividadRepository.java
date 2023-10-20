package upm;

public class ActividadRepository extends GenericRepository<Actividad>{
    @Override
    protected void setId(Actividad act, Integer id){
        act.setId(id);
    }
    @Override
    protected int getId(Actividad act){
        return act.getId();
    }
}
