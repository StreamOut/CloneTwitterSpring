package amu.m2sir.malodumont.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import amu.m2sir.malodumont.model.Like;

public interface LikeRepository extends CrudRepository<Like, Long>{
	
	Iterable<Like> findAll();
	<S extends Like> S save(S entity);
	Optional<Like> findById(Long primaryKey);
	void delete(Like entity);
	long count();
}
