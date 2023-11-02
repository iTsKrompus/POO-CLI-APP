package upm.Data.Repositories.Repositories_Map;

import upm.Data.Models.User;

public class UserRepository extends GenericRepository<User> {

    @Override
    protected void setId(User user, Integer telefono) {
        user.setTelefono(telefono);
    }

    @Override
    protected int getId(User user) {
        return user.getTelefono();
    }

}
