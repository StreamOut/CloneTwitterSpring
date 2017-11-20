package amu.m2sir.malodumont.repository;

import org.springframework.data.repository.CrudRepository;

import amu.m2sir.malodumont.Model.Message;


public interface MessageRepository extends CrudRepository<Message, Long>{
	
}
