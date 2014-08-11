package main.java.service;

import java.util.List;

import main.java.model.User;

public interface IUserService {    public void addUser (User user);
    public List<User> listUser();
    public void removeUser(Integer id);
    
}
