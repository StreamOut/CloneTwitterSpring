package amu.m2sir.malodumont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import amu.m2sir.malodumont.Model.*;
import amu.m2sir.malodumont.Model.MessageService;

@SpringBootApplication
public class CloneTwitterSpringApplication {

	public static LikeService likeService = new LikeService();
	public static MessageService messageService = new MessageService();

	public static void main(String[] args) {
		SpringApplication.run(CloneTwitterSpringApplication.class, args);
	}
}
