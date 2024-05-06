package com.kodnest.Serviceimple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.Entity.Song;
import com.kodnest.Repository.SongRepository;
import com.kodnest.Service.SongService;
@Service
public class SongServiceimple  implements SongService{
	@Autowired
	SongRepository songRepository;
	
	@Override
	public void savesong(Song song) {
		songRepository.save(song);
		}

	@Override
	public boolean songExists(String name) {
		Song song=songRepository.findByName(name); 
		if(song!=null) {
			return true;
		}else {
			return false;
	}
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs= songRepository.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
		
	}

	

		
	}


	
	

		
	


