package upm;

import upm.Data.Models.User;

import java.util.Optional;

public class UserContainer {
    private Optional<User> user;

    public UserContainer() {
        this.user = Optional.empty();
    }

    public Optional<User> getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user = Optional.of(user);
    }
    public void cleanUser(){
        this.user = Optional.empty();
    }
}
