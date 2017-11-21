package amu.m2sir.malodumont.Model;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amu.m2sir.malodumont.repository.LikeRepository;
import amu.m2sir.malodumont.repository.MessageRepository;

@Service
public class LikeService {
	@Autowired
	private LikeRepository repository;
	@Autowired
	private MessageRepository messageRepo;
	
	public LikeService(){}
	
	public int isAlreadyLike(List<Liike> likes, Long messageId, String user) {
		for (int i = 0; i < likes.size(); i++)
			if(likes.get(i).getMessage().getId().equals(messageId) &&likes.get(i).getLikeur().equals(user))
				return i;
		return -1;
	}
	
	public JsonArrayBuilder like(Long messageId, String user){
		System.out.println("Lke : Id : "+messageId+" user "+user);
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
		
		Liike like = repository.findByLikeurAndMessageId(user, messageId);
		 if (like != null) {
			 repository.delete(like);
			 objectBuilder.add("like", "");
		}
		else {
			
			like = new Liike(messageRepo.findOne(messageId),user);
			repository.save(like);
			objectBuilder.add("like", "true");
		}
		
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		objectBuilder.add("id", like.getMessage().getId());
		objectBuilder.add("user", like.getLikeur());

		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public JsonArrayBuilder getLikes(){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();

		Iterable<Liike> list = repository.findAll();
		  for (Liike l : list) {
			System.out.println("Get Likes : MessageId : "+ l.getMessage().getId() + " likeur "+ l.getLikeur());
			objectBuilder.add("id", l.getMessage().getId());
			objectBuilder.add("likeur", l.getLikeur());
			arrayBuilder.add(objectBuilder);
		  }
		return arrayBuilder;
	}
	
	public void deleteLikes(Long messageId){
		Iterable<Liike> list = repository.findAll();
		  for (Liike l : list) {
			System.out.println("deleteLikes : "+ l.getMessage().getId() +" message id :"+messageId);
			if(l.getMessage().getId().equals(messageId)){
				repository.delete(l);
				System.out.println("Delete "+messageId);
			}
		  }

	}


}
