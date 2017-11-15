package amu.m2sir.malodumont.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
    public String index() {
		System.out.println("lol");
        return "index"; 
	 }
}