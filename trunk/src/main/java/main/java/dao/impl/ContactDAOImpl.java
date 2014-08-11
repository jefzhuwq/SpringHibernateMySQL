package main.java.dao.impl;

import java.util.List;

import main.java.dao.IContactDAO;
import main.java.model.Contact;
import main.java.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements IContactDAO {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}
	
    @Override
	public List<Contact> listContact(int userid) {
		return sessionFactory.getCurrentSession().createQuery("from Contact where userid=" + userid).list();
	}
	
    @Override
	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}

	@Override
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
	}
	
}
