package amu.m2sir.malodumont.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String mail;
	private String pwd;
	
	public User(){
		
	}
	
	public User(String p, String pass){
		this.mail = p;
		this.pwd = pass;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String pseudo) {
		this.mail = pseudo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
