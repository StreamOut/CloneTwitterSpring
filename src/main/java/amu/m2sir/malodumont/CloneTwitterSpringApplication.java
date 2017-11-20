package amu.m2sir.malodumont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import amu.m2sir.malodumont.Model.LikeService;
import amu.m2sir.malodumont.Model.MessageService;

@SpringBootApplication
public class CloneTwitterSpringApplication {

	@Autowired
	public LikeService likeService;
	@Autowired
	public MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(CloneTwitterSpringApplication.class, args);
	}
}
