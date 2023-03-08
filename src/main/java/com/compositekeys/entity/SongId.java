package com.compositekeys.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class SongId implements Serializable {

	private static final long serialVersionUID = 4705781681979093984L;

	private String name;
	private String movie;
}
