package main.java.dao.impl;

import java.util.List;

import main.java.dao.IUserDAO;
import main.java.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements IUserDAO {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
	}
	
}
