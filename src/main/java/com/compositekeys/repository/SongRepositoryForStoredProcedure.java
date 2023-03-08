package com.compositekeys.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compositekeys.entity.Song;

@Service
public class SongRepositoryForStoredProcedure implements SongRepositoryCustomForSp {

	@Autowired
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Song> getSongsByMusician(String musician) {
		List<Song> songsData = em.createNamedStoredProcedureQuery("getsongsbymusician")
				.setParameter("musician", musician).getResultList();

		return songsData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Song> findAllSongsBySP() {
		StoredProcedureQuery songsData = em.createNamedStoredProcedureQuery("getsongs");
		return songsData.getResultList();
	}

	@Override
	public boolean insertdData(Song song) {
		
		boolean result=em.createNamedStoredProcedureQuery("insertsongs")
		.setParameter("movie", song.getSongId().getMovie())
		.setParameter("name", song.getSongId().getName())
		.setParameter("download_url", song.getDownloadUrl())
		.setParameter("duration", song.getDuration())
		.setParameter("genre", song.getGenre())
		.setParameter("musician", song.getMusician())
		.setParameter("rating", song.getRating())
		.setParameter("release_date", song.getReleaseDate())
		.setParameter("singer", song.getSinger()).execute();
		return result;
	}

}
