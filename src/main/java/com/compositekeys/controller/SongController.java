package com.compositekeys.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compositekeys.entity.Song;
import com.compositekeys.entity.SongId;
import com.compositekeys.service.SongService;

@RestController
@RequestMapping("/song")
public class SongController {

	@Autowired
	private SongService songService;

	@PostMapping("")
	public ResponseEntity<Iterable<Song>> save(@RequestBody Collection<Song> song) {
		long time = System.currentTimeMillis();

		Iterable<Song> savedSong = songService.save(song);
		long time2 = System.currentTimeMillis();

		System.out.println("elapsed Time" + (time2 - time));

		return new ResponseEntity<>(savedSong, HttpStatus.OK);
	}

	@GetMapping("/name/{name}/movie/{movie}") // compositekey
	public ResponseEntity<Song> getByCompositeKey(@PathVariable String name, @PathVariable String movie) {
		SongId sId = new SongId();
		sId.setMovie(movie);
		sId.setName(name);
		Song song = songService.findBySongId(sId);
		return new ResponseEntity<>(song, HttpStatus.OK);
	}

	@GetMapping("/{musician}")
	public ResponseEntity<Song> findByMusician(@PathVariable String musician) {
		Song song = songService.findByMusician(musician);
		return new ResponseEntity<>(song, HttpStatus.OK);

	}

	@GetMapping("/sp/musician/{musician}")
	public ResponseEntity<Collection<Song>> findsongBySP_musician(@PathVariable String musician) {
		Collection<Song> song = songService.findByMusicianUsingSP(musician);
		return new ResponseEntity<>(song, HttpStatus.OK);

	}

	@GetMapping("/sp")
	public ResponseEntity<Collection<Song>> findAllSongsBySP_Musician() {
		Collection<Song> song = songService.findAllSongsBySP();
		return new ResponseEntity<>(song, HttpStatus.OK);

	}

	@GetMapping("/sp/rating/{rating}")
	@Transactional(readOnly = true)
	public ResponseEntity<Collection<Song>> findAllSongsBySP_rating(@PathVariable int rating) {
		Collection<Song> song = songService.findSongsByRating(rating);
		return new ResponseEntity<>(song, HttpStatus.OK);

	}
	
	
	@PostMapping("/insertbysp")
	public ResponseEntity<Boolean> insertBySp(@RequestBody Song song){
	boolean result=	songService.insertBySP(song);
	return new ResponseEntity<>(result, HttpStatus.OK);

	}

}
