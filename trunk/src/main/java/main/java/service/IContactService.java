package main.java.service;

import java.util.List;

import main.java.model.Contact;

public interface IContactService {    public void addContact (Contact contact);
    public List<Contact> listContact(int userid);
    public Contact getContact(int userid);
    public void removeContact(Integer id);
    
}
