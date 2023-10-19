package upm;

import java.util.ArrayList;
import java.util.Iterator;

public class UserRepository {
    private ArrayList<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public User create(User user){
        userList.add(user);
        return user;
    }
    public User read(User user){
     userList.get(posList(user));
     return user;
    }
    public User update(User user){
    Iterator<User> it = userList.iterator();
    User user2;
    int i = 0;
    boolean encontrado = false;
       while(it.hasNext()&&!encontrado){
              user2= it.next();
           if(((user.getTelefono()== user2.getTelefono())&&(user.getNombreUsuario()==user2.getNombreUsuario()))){
               userList.set(i, user);
               encontrado =true;
           }
       i++;
       }
       return user;
    }


    public int posList(User user){
        boolean encontrado = true;
        int i;
        for(i=0;i<userList.size()&&encontrado;i++){
            if(userList.get(i)==user){
                encontrado=false;
            }
        }
        if(!encontrado){
            return i--;
        } else {
            System.out.println("Usuario no encontrado");
            return i;
        }
    }
    public void delete(User user){
        userList.remove(user);
    }
}
