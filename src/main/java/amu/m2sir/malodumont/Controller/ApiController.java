package amu.m2sir.malodumont.Controller;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import amu.m2sir.malodumont.Model.LikeService;
import amu.m2sir.malodumont.Model.MessageService;
import amu.m2sir.malodumont.Model.UserService;

@RestController
public class ApiController {
	@Autowired
	private HttpSession httpSession; // recupere la session en cours
	@Autowired
	private LikeService likeService;
	@Autowired
	MessageService ms;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String Submit(@RequestParam(value = "content", required = false) String content,
						@RequestParam(value = "action", required = false) String action,
						@RequestParam(value = "id", required = false) String id,
						@RequestParam(value = "mail", required = false) String mail,
						@RequestParam(value = "pwd", required = false) String pwd) {
		String sessionUser= (String) httpSession.getAttribute("user") ; // check l ' utilisateur ␣en␣cours
//		if(sessionUser == null)
//			sessionUser = "miiiiiiiiiiiiii";
	    //JsonObjectBuilder obj = Json.createObjectBuilder();
	    JsonArrayBuilder array = Json.createArrayBuilder();
	    //obj.add("user", sessionUser) ;
	    // pour acceder au parametre␣"content"␣par␣exemple
	    System.out.println(content);
	    if(action != null) {
	    //␣ici␣gerer␣les␣conditions␣d'action : add, remove, lookup, etc
	    	switch(action){
			case "list" : array = ms.getMessages(sessionUser); break;
			case "likeurs" : array = likeService.getLikes(); break;
			case "like" : array = likeService.like(Long.valueOf(id), sessionUser); break;
			case "add" : array = ms.addMessage(content,sessionUser); break;
			case "remove" : array = ms.deleteMessage(id); break;
			case "registration" : array = userService.registration(mail, pwd); break;
			case "login" : array = userService.connect(mail, pwd); break;
			case "loadRegistration" : return "registration";
			default : break;
		}
	    }
	return array.build().toString() ; // renvoi le contenu du json
	}
}