package amu.m2sir.malodumont.controller;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import amu.m2sir.malodumont.CloneTwitterSpring.CloneTwitterSpringApplication;
import amu.m2sir.malodumont.model.MessageService;

@RestController
public class ApiController {
	@Autowired
	private HttpSession httpSession; // recupere la session en cours
	MessageService ms = CloneTwitterSpringApplication.messageService;
	
	@RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String Submit(@RequestParam(value = "content", required = false) String content,
	@RequestParam(value = "action", required = false) String action,
	@RequestParam(value = "id", required = false) String id) 
	{
		String sessionUser= (String) httpSession.getAttribute("user") ; // check l ' utilisateur ␣en␣cours
	    //JsonObjectBuilder obj = Json.createObjectBuilder();
	    JsonArrayBuilder array = Json.createArrayBuilder();
	    //obj.add("user", sessionUser) ;
	    // pour acceder au parametre␣"content"␣par␣exemple
	    System.out.println(content);
	    if(action != null) {
	    //␣ici␣gerer␣les␣conditions␣d'action : add, remove, lookup, etc
	    	switch(action){
			case "list" : array = ms.getMessages(sessionUser); break;
			//case "likeurs" : array = likeService.getLikes(); break;
			//case "like" : array = likeService.like(Long.valueOf(id), sessionUser); break;
			case "add" : array = ms.addMessage(content,sessionUser); break;
			case "remove" : array = ms.deleteMessage(id); break;
			//case "registration" : array = userService.registration(parametres.get("user")[0], parametres.get("pwd")[0], req); break;
			//case "login" : array = userService.connect(parametres.get("user")[0], parametres.get("pwd")[0], req); break;
			default : break;
		}
	    }
	return array.build().toString() ; // renvoi le contenu du json
	}
}