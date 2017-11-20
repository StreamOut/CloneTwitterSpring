package amu.m2sir.malodumont.Model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amu.m2sir.malodumont.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private UserRepository repository;
	public UserService(){}
	
	public JsonArrayBuilder connect(String username, String pwd){
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();

		User user = (User) repository.findOne(username);
			if (user != null && pwd.equals(user.getPwd())) {
				httpSession.setAttribute("user", username);
			objectBuilder.add("user", username);
			objectBuilder.add("auth", "true");
		}
		else {
			objectBuilder.add("message", "Mail ou Mot de passe incorecte");
			objectBuilder.add("auth", "");
		}
		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}
	
	public JsonArrayBuilder registration(String mail, String pwd){
		System.out.println("lol");
		User user = new User(mail, pwd);
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder objectBuilder =Json.createObjectBuilder();

		User userOld = (User) repository.findOne(mail);
		if(userOld == null){
			System.out.println("okay");
			repository.save(user);
			httpSession.setAttribute("user", mail);
			objectBuilder.add("user", mail);
			objectBuilder.add("auth", "true");
		  }
		  else {
			  objectBuilder.add("message", "Ce Mail est déjà utilisé");
			  objectBuilder.add("auth", "");
		  }
		arrayBuilder.add(objectBuilder);
		return arrayBuilder;
	}

}
