package main.java.dao;

import java.util.List;

import main.java.model.User;

public interface IUserDAO {

    public void addUser (User user);
    public List<User> listUser();
    public void removeUser(Integer id);
}
