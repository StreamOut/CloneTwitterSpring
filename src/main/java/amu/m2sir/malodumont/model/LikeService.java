package amu.m2sir.malodumont.model;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import org.springframework.stereotype.Service;

import amu.m2sir.malodumont.repository.LikeRepository;

@Service
public class LikeService {
	private LikeRepository repository;
	
	public LikeService(){
		//hibernateUtil.executeUpdate( "CREATE TABLE IF NOT EXISTS likes " +
               // "(id int, messageId int, likeur varchar(255)); ");
	}
	
	public int isAlreadyLike(List<Like> likes, Long messageId, String user) {
		for (int i = 0; i < likes.size(); i++)
			if(likes.get(i).getMessageId().equals(messageId) &&likes.get(i).getLikeur().equals(user))
				return i;
		return -1;
	}
	
	public JsonArrayBuilder like(Long messageId, String user){
		System.out.println("Id : "+messageId+" user "+user);
		Like like = new Like(messageId,user);
		int already;
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
//		
//		List<Like> list = new ArrayList<Like>(hibernateUtil.getSession().createQuery("from amu.m2sir.malodumont.beans.Like").list() );
//		  already = isAlreadyLike(list, messageId, user);
//		  if (already != -1) {
//				hibernateUtil.getSession().delete(list.get(already));
//				objectBuilder.add("like", "");
//		}
//		else {
//			hibernateUtil.getSession().save(like);
//			objectBuilder.add("like", "true");
//		}
//		hibernateUtil.getSession().getTransaction().commit();
//		hibernateUtil.getSession().flush();
		
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		objectBuilder.add("id", like.getMessageId());
		objectBuilder.add("user", like.getLikeur());

		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public JsonArrayBuilder getLikes(){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();

		Iterable<Like> list = repository.findAll();
		  for (Like l : list) {
			System.out.println("MessageId : "+ l.getMessageId() + " likeur "+ l.getLikeur());
			objectBuilder.add("id", l.getMessageId());
			objectBuilder.add("likeur", l.getLikeur());
			arrayBuilder.add(objectBuilder);
		  }
		return arrayBuilder;
	}
	
	public void deleteLikes(Long messageId){
		Iterable<Like> list = repository.findAll();
		  for (Like l : list) {
			System.out.println("deleteLikes : "+ l.getMessageId() +" message id :"+messageId);
			if(l.getMessageId().equals(messageId)){
				repository.delete(l);
				System.out.println("Delete "+messageId);
			}
		  }

	}


}
