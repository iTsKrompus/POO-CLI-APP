package upm;

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
