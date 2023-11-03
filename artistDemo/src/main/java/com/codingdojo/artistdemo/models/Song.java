package com.codingdojo.artistdemo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="songs")
public class Song {
	// Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Timestamp fields
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date(); // Generate the time stamp for updatedAt when adding a new Artist
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    /* Additional attributes go here - including relationships!!! */
    @NotEmpty(message="Please enter the title of the song")
    @Column(columnDefinition="TEXT")
    private String title;
    
    @NotNull(message="Please enter the release date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date releaseDate;
    
    @NotNull(message="Please say whether this song has explicit lyrics")
    private Boolean isExplicit;
    
    @NotEmpty(message="Please enter at least some lyrics to the song")
    @Column(columnDefinition="TEXT")
    private String lyrics;
    
    /* Adding a one-to-many relationship */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="artist_id")
    private Artist recordingArtist;
    
    // Zero-argument constructor (required per Java bean conventions)
    public Song() {}
    
    // Getters and setters - IMPORTANT - add/remove getters and setters as needed when attributes are added/removed!!!
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Boolean getIsExplicit() {
		return isExplicit;
	}
	public void setIsExplicit(Boolean isExplicit) {
		this.isExplicit = isExplicit;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public Artist getRecordingArtist() {
		return recordingArtist;
	}
	public void setRecordingArtist(Artist recordingArtist) {
		this.recordingArtist = recordingArtist;
	}
    
    
}