package amu.m2sir.malodumont.controller;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
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
	@RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.
	APPLICATION_JSON_VALUE)
	public String Submit(@RequestParam(value = "content", required = false) String content,
	@RequestParam(value = "action", required = false) String action,
	@RequestParam(value = "id", required = false) String id) {
	String sessionUser= (String) httpSession.getAttribute("user") ; // check l ' utilisateur ␣en␣cours
	    JsonObjectBuilder obj = Json.createObjectBuilder();
	    obj.add("user", sessionUser) ;
	    // pour acceder au parametre␣"content"␣par␣exemple
	    System.out.println(content);
	    if(action != null) {
	    //␣ici␣gerer␣les␣conditions␣d'action : add, remove, lookup, etc
	}
	return obj.build().toString() ; // renvoi le contenu du json
	}
}