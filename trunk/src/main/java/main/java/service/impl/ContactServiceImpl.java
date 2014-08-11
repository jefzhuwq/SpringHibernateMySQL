package main.java.service.impl;

import java.util.List;

import main.java.dao.IContactDAO;
import main.java.model.Contact;
import main.java.service.IContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements IContactService {
	
    @Autowired
    private IContactDAO contactDAO;
    
    @Override
    @Transactional
    public void addContact(Contact contact) {
    	contactDAO.addContact(contact);
    }
    
    @Override
    @Transactional
    public List<Contact> listContact(int userid) {
        return contactDAO.listContact(userid);
    }
    
    @Override
    @Transactional
    public void removeContact(Integer id) {
    	contactDAO.removeContact(id);
    }

}
