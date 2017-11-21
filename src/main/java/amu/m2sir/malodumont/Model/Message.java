package amu.m2sir.malodumont.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String contenu;
	private String date;
	private String auteur;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message") //␣il␣faut␣indiquer␣le␣type␣de␣la␣classe␣parent␣dans␣mappedBy,␣et␣non␣la␣propriete␣id
	@Cascade({CascadeType.REMOVE}) //␣permet␣de␣supprimer␣en␣cascade␣les␣liikes␣associes
	private Set<Liike> likes = new HashSet<Liike>(0);
	
	public Message() {
		
	}
	
	public Message (String contenu, String date, String auteur){
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
