package amu.m2sir.malodumont.repository;


import org.springframework.data.repository.CrudRepository;

import amu.m2sir.malodumont.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	

}