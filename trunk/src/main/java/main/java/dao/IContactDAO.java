package main.java.dao;

import java.util.List;

import main.java.model.Contact;

public interface IContactDAO {

    public void addContact (Contact contact);
    public void updateContact (Contact contact);
    public List<Contact> listContact(int userid);
    public void removeContact(Integer id);
}
