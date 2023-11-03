package com.codingdojo.artistdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.artistdemo.models.Artist;
import com.codingdojo.artistdemo.services.ArtistService;

import jakarta.validation.Valid;

@Controller
public class ArtistController {
	// Short-hand dependency injection
	@Autowired
	private ArtistService artistService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/artists";
	}
	
	// Form to create an artist
	@GetMapping("/artists/new")
	public String newArtistFormPage(@ModelAttribute("newArtist") Artist newArtist, Model model) {
		String[] musicGenres = {"Pop", "Rock", "Folk", "Metal", "Metalcore", "R&B", "EDM"};
		model.addAttribute("allGenres", musicGenres);
		return "newArtist.jsp";
	}
	
	// Shows one artist
	@GetMapping("/artists/{id}")
	public String viewOneArtistPage(@PathVariable("id") Long id, Model model) {
		Artist thisArtist = artistService.findArtist(id);
		model.addAttribute("thisArtist", thisArtist);
		return "oneArtist.jsp";
	}
	
	@GetMapping("/artists/{id}/edit")
	public String editArtistPage(@PathVariable("id") Long id, Model model) {
		Artist thisArtist = artistService.findArtist(id);
		String[] musicGenres = {"Pop", "Rock", "Folk", "Metal", "Metalcore", "R&B", "EDM"};
		model.addAttribute("allGenres", musicGenres);
		model.addAttribute("artistToEdit", thisArtist);
		return "editArtist.jsp";
	}
	
	@PutMapping("/artists/{id}/edit")
	public String editArtist(@PathVariable("id") Long id, @Valid @ModelAttribute("artistToEdit") Artist editedArtist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String[] musicGenres = {"Pop", "Rock", "Folk", "Metal", "Metalcore", "R&B", "EDM"};
			model.addAttribute("allGenres", musicGenres);
			return "editArtist.jsp";
		}
		artistService.editArtist(editedArtist);
		return "redirect:/";
	}
	
	// Shows all artists
	@GetMapping("/artists")
	public String showAllArtistsPage(Model model) {
		List<Artist> allArtists = artistService.readAllArtists();
		model.addAttribute("allArtists", allArtists);
		return "allArtists.jsp";
	}
	
	// Add an artist
	@PostMapping("/artists/new")
	public String addArtist(@Valid @ModelAttribute("newArtist") Artist newArtist, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// Contrary to usual practice, we need to return a .jsp page for error messages to show up.
			String[] musicGenres = {"Pop", "Rock", "Folk", "Metal", "Metalcore", "R&B", "EDM"};
			model.addAttribute("allGenres", musicGenres);
			return "newArtist.jsp";
		}
		artistService.createArtist(newArtist);
		return "redirect:/artists";
	}
	
	@DeleteMapping("/artists/{id}/delete")
	public String deleteArtist(@PathVariable("id") Long id) {
		artistService.deleteArtist(id);
		return "redirect:/artists";
	}
	
}
