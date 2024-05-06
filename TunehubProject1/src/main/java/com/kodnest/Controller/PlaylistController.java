package com.kodnest.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.Entity.Playlist;
import com.kodnest.Entity.Song;
import com.kodnest.Service.PlaylistService;
import com.kodnest.Service.SongService;
@Controller
public class PlaylistController {

@Autowired
	PlaylistService playlistservice;

@Autowired
SongService songService;

@GetMapping("/createplaylists")
public String createplaylist(Model model) {
	List<Song> songList = songService.fetchAllSongs();
	model.addAttribute("songs",songList);
	return "createplaylist";
}
@PostMapping("/addplaylist")
public String addplaylist(@ModelAttribute Playlist playlist) {
	playlistservice.addplaylist(playlist);
	//updating the song_playlist table
	List<Song> songs = playlist.getSongs();
	for(Song song:songs) {
		song.getPlayLists().add(playlist);
		songService.updateSong(song);
	}
	return "adminhome";
	
	
}
@GetMapping("/viewplaylists")
public String viewplaylist( Model model) {
	List<Playlist>allplaylist=playlistservice.fetchAllPlaylists();
	model.addAttribute("playlist",allplaylist);
	return "viewplaylist";
	
}



}
