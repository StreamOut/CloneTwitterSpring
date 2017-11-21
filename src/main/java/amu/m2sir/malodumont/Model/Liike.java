package amu.m2sir.malodumont.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Liike {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String likeur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.REFRESH}) //␣mise␣a␣jour␣des␣liikes␣du␣message
	private Message message;
	
	public Liike(){
		
	}
	
	public Liike(Message message, String l){
		this.message = message;
		this.likeur = l;
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	
	

}
