package com.kodnest.Service;

import java.util.List;

import com.kodnest.Entity.Song;

public interface SongService {

	void savesong(Song song);

	boolean songExists(String name);

	List<Song> fetchAllSongs();

	void updateSong(Song song);

	
	

}
