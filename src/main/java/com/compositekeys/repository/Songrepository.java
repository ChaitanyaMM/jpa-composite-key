package com.compositekeys.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.compositekeys.entity.Song;
import com.compositekeys.entity.SongId;

@Repository
public interface Songrepository extends JpaRepository<Song, SongId> {

	Song findBySongId(SongId sId);

	Song findByMusician(String musician);

	// approach-1
	@Procedure(name = "getsongsbyrating")
	List<Song> get_songs_by_rating(int rating);

//	// approach-2
//	@Procedure("get_songs_by_rating")
//	Song getAllsongbyTitle(String rating);
//
//	// approach-3
//	@Procedure(procedureName = "get_songs_by_rating")
//	Song getAllsongbyTitle(String rating);
//
//	// approach-4
//	@Procedure(value = "get_songs_by_rating")
//	Song getAllsongbyTitle(String rating);

}
