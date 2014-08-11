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
@Table(name="USER")
public class User {
	
    @Id
    @Column(name="USERID")
    @GeneratedValue
    private Integer id;
    
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="PASSWORD")
    private String password;
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public String getUserName () {
        return username;
    }
    
    public void setUserName (String name) {
        this.username = name;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
