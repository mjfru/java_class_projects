package com.codingdojo.artistdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.artistdemo.models.Song;
import com.codingdojo.artistdemo.repositories.SongRepository;

@Service // Remember to include this annotation!
public class SongService {
	
	@Autowired
	private SongRepository songRepo;
	
	// Creating a new Song
	public Song createSong(Song newSong) {
		return songRepo.save(newSong);
	}
	
	// Grabbing all Songs
	public List<Song> readAllSongs() {
		return songRepo.findAll();
	}
	
	// Grabbing one Song
	public Song readOneSong(Long id) {
		Optional<Song> songOrNull = songRepo.findById(id); // Try to grab the Song by ID
		return songOrNull.isPresent() ? songOrNull.get() : null;
	}
	
	// Editing one Song
	public Song editSong(Song editedSong) {
		return songRepo.save(editedSong);
	}
	
	// Deleting a Song
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
}