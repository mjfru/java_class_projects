package com.codingdojo.artistdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.artistdemo.models.Artist;
import com.codingdojo.artistdemo.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	// Adding the repository in as a dependency
	private final ArtistRepository artistRepository;
	
	public ArtistService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}
	
	
	// Create a new Artist
	public Artist createArtist(Artist newArtist) {
		return artistRepository.save(newArtist);
	}
	
	// Read all
	public List<Artist> readAllArtists() {
		return artistRepository.findAll();
	}
		
	// Read one
	public Artist findArtist(Long id) {
		Optional<Artist> optionalArtist = artistRepository.findById(id);
		// New way to do this with a ternary operator:
		// return condition ? valueIfTrue : valueIfFalse
		return optionalArtist.isPresent() ? optionalArtist.get() : null;
	}
	
	// Editing one artist
	public Artist editArtist(Artist editedArtist) {
		return artistRepository.save(editedArtist);
	}
	
	// Delete
	public void deleteArtist(Long id) {
		artistRepository.deleteById(id); 
		// Or, you can do .delete(artistToDelete), where you pass in the object itself.
	}
	
	// Get all artists by name is ascending order
	public List<Artist> readAllInAlphabeticalOrder() {
		List<Artist> allArtists = artistRepository.findAllByOrderByNameAsc();
		return allArtists;
	}
	
	// Get all groups
	public List<Artist> findAllGroups() {
		List<Artist> groups = artistRepository.findAllByIsGroupTrue();
		return groups;
	}
}
