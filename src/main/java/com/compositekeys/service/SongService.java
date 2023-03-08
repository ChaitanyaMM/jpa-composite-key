package com.compositekeys.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.compositekeys.entity.Song;
import com.compositekeys.entity.SongId;
import com.compositekeys.repository.SongRepositoryCustomForSp;
import com.compositekeys.repository.Songrepository;

@Component
public class SongService {

	@Autowired
	private Songrepository songRepository;

	@Autowired
	private SongRepositoryCustomForSp songsRepoBySP;

	public Iterable<Song> save(Collection<Song> song) {
		Iterable<Song> s = songRepository.saveAll(song);
		return s;
	}

	public Song findBySongId(SongId sId) {
		Song s = songRepository.findBySongId(sId);
		return s;
	}

	public Song findByMusician(String musician) {
		Song s = songRepository.findByMusician(musician);
		return s;
	}

	public Collection<Song> findByMusicianUsingSP(String musician) {
		return songsRepoBySP.getSongsByMusician(musician);
	}

	public Collection<Song> findAllSongsBySP() {
		return songsRepoBySP.findAllSongsBySP();
	}

	public Collection<Song> findSongsByRating(int rating) {
		return songRepository.get_songs_by_rating(rating);

	}

	public boolean insertBySP(Song song) {
		return songsRepoBySP.insertdData(song);
	}

}
