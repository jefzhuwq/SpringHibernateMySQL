package main.java.service.impl;

import java.util.List;

import main.java.dao.IUserDAO;
import main.java.model.User;
import main.java.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	
    @Autowired
    private IUserDAO userDAO;
    
    @Transactional
    public void addUser(User user) {
    	userDAO.addUser(user);
    }
    
    @Transactional
    public List<User> listUser() {
        return userDAO.listUser();
    }
    
    @Transactional
    public void removeUser(Integer id) {
    	userDAO.removeUser(id);
    }
}
