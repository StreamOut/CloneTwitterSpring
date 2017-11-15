package amu.m2sir.malodumont.Model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	//private HibernateUtil hibernateUtil = App.hibernateUtil;
	
	public UserService(){
//		hibernateUtil.executeUpdate( "CREATE TABLE IF NOT EXISTS user " +
//                "(mail varchar(255), pwd varchar(255)); ");
	}
	
	public JsonArrayBuilder connect(String username, String pwd, HttpServletRequest req){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
//		final Session session = hibernateUtil.getSession();
//		try {
//		  final Transaction transaction = session.beginTransaction();
//		  try {
//		    // The real work is here
//			  User user = (User) session.get(User.class, username);
//				if (user != null && pwd.equals(user.getPwd())) {
//					req.getSession().setAttribute("user", username);
//					objectBuilder.add("user", username);
//					objectBuilder.add("auth", "true");
//				}
//				else {
//					objectBuilder.add("message", "Mail ou Mot de passe incorecte");
//					objectBuilder.add("auth", "");
//				}
//			  transaction.commit();
//		  } catch (Exception ex) {
//		    // Log the exception here
//		    transaction.rollback();
//		    throw ex;
//		  }
//		} finally {
//		  session.flush();
//		}
		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public JsonArrayBuilder registration(String mail, String pwd, HttpServletRequest req){
		System.out.println("lol");
		User user = new User(mail, pwd);
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();
//		final Session session = hibernateUtil.getSession();
//		try {
//		  final Transaction transaction = session.beginTransaction();
//		  try {
//		    // The real work is here
//			  User userOld = (User) session.get(User.class, mail);
//			  if(userOld == null){
//				  System.out.println("okay");
//				  session.save(user);
//				  req.getSession().setAttribute("user", mail);
//				  objectBuilder.add("user", mail);
//				  objectBuilder.add("auth", "true");
//			  }
//			  else {
//				  objectBuilder.add("message", "Ce Mail est déjà utilisé");
//				  objectBuilder.add("auth", "");
//			  }
//			  transaction.commit();
//		  } catch (Exception ex) {
//		    // Log the exception here
//		    transaction.rollback();
//		    throw ex;
//		  }
//		} finally {
//		  session.flush();
//		}
		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}

}
