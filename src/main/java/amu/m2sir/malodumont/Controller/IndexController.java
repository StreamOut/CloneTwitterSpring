package amu.m2sir.malodumont.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@Autowired
	private HttpSession httpSession; // recupere la session en cours

	@GetMapping("/")
    public String index() {
		String sessionUser= (String) httpSession.getAttribute("user") ; // check l ' utilisateur ␣en␣cours
		if(sessionUser == null)
			return "login";
        return "index"; 
	 }
	
	@GetMapping("/register")
	public String Submit() {
		return "registration" ;
	}
}