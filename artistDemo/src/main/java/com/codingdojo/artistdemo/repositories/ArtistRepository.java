package com.codingdojo.artistdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.artistdemo.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
	// Gets all Artists from the database
	List<Artist> findAll();
	
//	Get all by name in ascending order
	List<Artist> findAllByOrderByNameAsc();
	
// 	Get all artists who are in a group
	List<Artist> findAllByIsGroupTrue();
}
