package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT")
public class Contact {
	
    @Id
    @Column(name="CONTACTID")
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERID")
    private User user;
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}