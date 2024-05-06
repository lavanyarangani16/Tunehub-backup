package com.kodnest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.Entity.Playlist;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {

	public Playlist findByName(String string);

}
