package main.java.controller;

import java.util.List;

import main.java.model.Contact;
import main.java.service.IContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController extends BasicController {
	
	@Autowired
    private IContactService contactService;
	
	@RequestMapping(value = URL_CONTACTS, method = RequestMethod.GET)
    public ModelAndView listContacts() {
        ModelAndView mav = new ModelAndView(TILES_CONTACTS);
        
        List<Contact> contacts = contactService.listContact(1);
        
        mav.addObject("contacts", contacts);
        
        return mav;
    }
	
	@RequestMapping(value = URL_CONTACTS_NEW, method = RequestMethod.GET)
    public ModelAndView newContacts() {
        ModelAndView mav = new ModelAndView(TILES_CONTACTS_NEW);
        return mav;
    }
}
