package com.kodnest.Service;

import java.util.List;

import com.kodnest.Entity.Playlist;

public interface PlaylistService {

	

	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

	

}
