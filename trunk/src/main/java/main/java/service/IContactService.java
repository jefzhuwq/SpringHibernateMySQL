package main.java.service;

import java.util.List;

import main.java.model.Contact;

public interface IContactService {
    public List<Contact> listContact(int userid);
    public void removeContact(Integer id);
    
}