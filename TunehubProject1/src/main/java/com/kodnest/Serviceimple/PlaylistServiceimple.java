package com.kodnest.Serviceimple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.Entity.Playlist;
import com.kodnest.Entity.Song;
import com.kodnest.Repository.PlaylistRepository;
import com.kodnest.Service.PlaylistService;
@Service
public class PlaylistServiceimple implements PlaylistService {
@Autowired
PlaylistRepository playlistRepository;



@Override
public void addplaylist(Playlist playlist) {
	Playlist existplaylist = playlistRepository.findByName(playlist.getName()); 
	if(existplaylist ==null) {
		playlistRepository.save(playlist);
	}else {
		System.out.println("Playlist already exists!");
}
	
}



@Override
public List<Playlist> fetchAllPlaylists() {
	List<Playlist>allplaylist=playlistRepository.findAll();
	return allplaylist;
	
}





}
