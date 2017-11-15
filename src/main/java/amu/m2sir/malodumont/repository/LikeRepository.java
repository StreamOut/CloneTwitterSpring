package amu.m2sir.malodumont.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import amu.m2sir.malodumont.Model.Liike;

public interface LikeRepository extends CrudRepository<Liike, Long>{
	
	Iterable<Liike> findAll();
	<S extends Liike> S save(S entity);
	Optional<Liike> findById(Long primaryKey);
	void delete(Liike entity);
	long count();
}
