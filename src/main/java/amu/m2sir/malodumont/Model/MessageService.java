package amu.m2sir.malodumont.Model;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amu.m2sir.malodumont.CloneTwitterSpringApplication;
import amu.m2sir.malodumont.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private LikeService likeService;
	@Autowired
	private MessageRepository repository;
	
	public MessageService (){
//		hibernateUtil.executeUpdate( "CREATE TABLE IF NOT EXISTS message " +
//                "(id int, contenu varchar(255), date varchar(255), auteur varchar(255)); ");
		
	}
	
	public JsonArrayBuilder getMessages(String user){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		Iterable<Message> list = repository.findAll();
		
		//List<Like> Likelist = new ArrayList<Like>(hibernateUtil.getSession().createQuery("from amu.m2sir.malodumont.model.Like").list() );
		for (Message m : list) {
			JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
			System.out.println("LOOOOOL : " + m.getContenu());
			objectBuilder.add("contenu", m.getContenu());
			objectBuilder.add("date", m.getDate());
			objectBuilder.add("auteur", m.getAuteur());
			objectBuilder.add("id", m.getId());
//			if(likeService.isAlreadyLike(Likelist, m.getId(), user) != -1)
//				objectBuilder.add("like", "true");
//			else
				objectBuilder.add("like", "");
			objectBuilder.add("nbMessage", nbMessage());
			arrayBuilder.add(objectBuilder);
		}
		return arrayBuilder;
	}
	
	public JsonArrayBuilder addMessage(String contenu, String user){
		System.out.println("Contenu :" + contenu);
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
		Message message;
		Date aujourdhui = new Date();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		message = new Message(contenu, formater.format(aujourdhui), user);
		
		repository.save(message);
		System.out.println(message.getContenu());

		objectBuilder.add("contenu", message.getContenu());
		objectBuilder.add("date", message.getDate());
		objectBuilder.add("auteur", message.getAuteur());
		objectBuilder.add("id", message.getId());
		objectBuilder.add("nbMessage", nbMessage());
		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public JsonObjectBuilder getMessage(Long id){
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
		Message message = repository.findOne(new Long(id));
		if (message == null) {
			return objectBuilder;
		}
		objectBuilder.add("contenu", message.getContenu());
		objectBuilder.add("date", message.getDate());
		objectBuilder.add("auteur", message.getAuteur());
		objectBuilder.add("id", message.getId());
		objectBuilder.add("nbMessage", nbMessage());
		return objectBuilder;
	}
	
	public JsonArrayBuilder deleteMessage(String id){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();

		Message message = repository.findOne(new Long(id));
		if (message != null) {
			repository.delete(message);
		}

		likeService.deleteLikes(new Long(id));
		objectBuilder.add("id", id);
		objectBuilder.add("nbMessage", nbMessage());
		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public Long nbMessage (){
		return repository.count();
	}

}
