package amu.m2sir.malodumont.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Like {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long messageId;
	private String likeur;
	
	public Like(){
		
	}
	
	public Like(Long m, String l){
		this.messageId = m;
		this.likeur = l;
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public String getLikeur() {
		return likeur;
	}
	public void setLikeur(String likeur) {
		this.likeur = likeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
