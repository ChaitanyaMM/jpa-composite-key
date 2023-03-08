package com.compositekeys.entity;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "song")
@Data

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getsongs", procedureName = "get_songs", resultClasses = Song.class),
		@NamedStoredProcedureQuery(name = "getsongsbyrating", procedureName = "get_songs_by_rating", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rating", type = Integer.class) }),
		@NamedStoredProcedureQuery(name = "getsongsbymusician", procedureName = "get_songs_by_musician", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "musician", type = String.class) }),

		@NamedStoredProcedureQuery(name = "insertsongs", procedureName = "insert_songs", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "movie", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "download_url", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "duration", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "genre", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "musician", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rating", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "release_date", type = LocalDateTime.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "singer", type = String.class) }) })

public class Song {
	@EmbeddedId
	private SongId songId;
	private int duration;
	private String musician;
	private String singer;
	private String genre;
	private LocalDateTime releaseDate;
	private int rating;
	private String downloadUrl;
}
