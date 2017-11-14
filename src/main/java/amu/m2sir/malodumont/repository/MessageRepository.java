package amu.m2sir.malodumont.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import amu.m2sir.malodumont.model.Message;


public interface MessageRepository extends CrudRepository<Message, Long>{
	
	Iterable<Message> findAll();
	<S extends Message> S save(S entity);
	Optional<Message> findById(Long primaryKey);
	void delete(Message entity);
	long count();
}
