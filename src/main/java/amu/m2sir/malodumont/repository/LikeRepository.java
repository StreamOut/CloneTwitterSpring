package amu.m2sir.malodumont.repository;

import org.springframework.data.repository.CrudRepository;

import amu.m2sir.malodumont.Model.Liike;

public interface LikeRepository extends CrudRepository<Liike, Long>{
	
	public Liike findByLikeurAndMessageId(String likeur, Long messageId);
}
