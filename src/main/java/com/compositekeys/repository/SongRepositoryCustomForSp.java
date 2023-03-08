package com.compositekeys.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.compositekeys.entity.Song;

public interface SongRepositoryCustomForSp {

	List<Song> getSongsByMusician(String musician);

	Collection<Song> findAllSongsBySP();

	boolean insertdData(Song song);

}
