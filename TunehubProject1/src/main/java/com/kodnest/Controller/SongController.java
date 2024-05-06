package com.kodnest.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.Entity.Song;
import com.kodnest.Entity.User;
import com.kodnest.Service.SongService;


@Controller
public class SongController {
	@Autowired
	SongService songservice;
@PostMapping("/addsongs")
public String addSong(@ModelAttribute Song song) {
	String name=song.getName();
	boolean songExists= songservice.songExists(name);
	if(songExists==false) {
		songservice.savesong(song);
		System.out.println("song added successfully");
		}else {
			System.out.println("Duplicate song");
		}

	return "adminhome";
	
}
@GetMapping("/playsongs")
public String playsongs( Model model) {
	boolean premium=true;
	if( premium) {
	List<Song> songslist=songservice.fetchAllSongs();
	model.addAttribute("songs",songslist);
	
	System.out.println(songslist);
	return "viewsongs";
}else {
		return "pay";
	}
	
}
@GetMapping("/viewsongs")
public String viewsongs( Model model) {
	List<Song> songslist=songservice.fetchAllSongs();
	model.addAttribute("songs",songslist);
	
	System.out.println(songslist);
	return "view songs";
	
}
}




