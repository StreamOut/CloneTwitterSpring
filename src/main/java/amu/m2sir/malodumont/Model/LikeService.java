package amu.m2sir.malodumont.Model;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amu.m2sir.malodumont.repository.LikeRepository;

@Service
public class LikeService {
	@Autowired
	private LikeRepository repository;
	
	public LikeService(){}
	
	public int isAlreadyLike(List<Liike> likes, Long messageId, String user) {
		for (int i = 0; i < likes.size(); i++)
			if(likes.get(i).getMessageId().equals(messageId) &&likes.get(i).getLikeur().equals(user))
				return i;
		return -1;
	}
	
	public JsonArrayBuilder like(Long messageId, String user){
		System.out.println("Id : "+messageId+" user "+user);
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
		
		Liike like = repository.findByLikeurAndMessageId(user, messageId);
		 if (like != null) {
			 repository.delete(like);
			 objectBuilder.add("like", "");
		}
		else {
			like = new Liike(messageId,user);
			repository.save(like);
			objectBuilder.add("like", "true");
		}
		
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		objectBuilder.add("id", like.getMessageId());
		objectBuilder.add("user", like.getLikeur());

		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public JsonArrayBuilder getLikes(){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();

		Iterable<Liike> list = repository.findAll();
		  for (Liike l : list) {
			System.out.println("MessageId : "+ l.getMessageId() + " likeur "+ l.getLikeur());
			objectBuilder.add("id", l.getMessageId());
			objectBuilder.add("likeur", l.getLikeur());
			arrayBuilder.add(objectBuilder);
		  }
		return arrayBuilder;
	}
	
	public void deleteLikes(Long messageId){
		Iterable<Liike> list = repository.findAll();
		  for (Liike l : list) {
			System.out.println("deleteLikes : "+ l.getMessageId() +" message id :"+messageId);
			if(l.getMessageId().equals(messageId)){
				repository.delete(l);
				System.out.println("Delete "+messageId);
			}
		  }

	}


}
