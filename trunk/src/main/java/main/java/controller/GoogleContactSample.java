package main.java.controller;

import java.io.IOException;
import java.net.URL;
import com.google.gdata.data.Link;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.util.ServiceException;

public class GoogleContactSample {
	public static void main(String[] args) throws IOException, ServiceException {
		ContactsService service = new ContactsService("TestProject");
		String userName = "jeffery821217@gmail.com";
	    String password = "1234@qwer";
	    service.setUserCredentials(userName, password);
	    
	    URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/jeffery821217@gmail.com/full");
	    ContactFeed resultFeed = service.getFeed(feedUrl, ContactFeed.class);
	    for (ContactEntry entry : resultFeed.getEntries()) {
	        System.out.println(entry.getEmailAddresses());  
    	}
	    
	}
	
	private static void printContact(ContactEntry contact) {
	    System.err.println("Id: " + contact.getId()); 
	    if (contact.getTitle() != null) {
	      System.err.println("Contact name: " + contact.getTitle().getPlainText());
	    } else {
	      System.err.println("Contact has no name");
	      
	    }
	    System.err.println("Last updated: " + contact.getUpdated().toUiString());
	    if (contact.hasDeleted()) {
	      System.err.println("Deleted:");
	    }

	    //ElementHelper.printContact(System.err, contact);
	    
	    Link photoLink = contact.getLink(
	        "http://schemas.google.com/contacts/2008/rel#photo", "image/*");
	    System.err.println("Photo link: " + photoLink.getHref());
	    String photoEtag = photoLink.getEtag();
	    System.err.println("  Photo ETag: "
	        + (photoEtag != null ? photoEtag : "(No contact photo uploaded)"));
	    System.err.println("Self link: " + contact.getSelfLink().getHref());
	    System.err.println("Edit link: " + contact.getEditLink().getHref());
	    System.err.println("ETag: " + contact.getEtag());
	    System.err.println("-------------------------------------------\n");
	  }
}
