package com.codingdojo.artistdemo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="artists")
public class Artist {
	// Generates our primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	// Time Stamps:
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// Active or not
	@NotNull(message="Please select whether this artist/group is active.")
	private Boolean isActive;
	
	// Genre
	@NotBlank(message="Please select a genre.")
	@Size(min = 3, max = 255, message="Genre must be between 3 and 255 characters.")
	private String genre;
	
	// Name of Artist
	@NotBlank(message="Please enter a name.")
	@Size(min = 1, max = 255, message="Name must be between 1 and 255 characters.")
	private String name;
	
	// Description
	@NotBlank(message="Please enter a description.")
	@Size(min = 10, message="Description must be at least 10 characters.")
	@Column(columnDefinition="TEXT")
	private String description;
	
	// Solo or Group
	@NotNull(message="Please indicate if this is a solo artist or group.")
	private Boolean isGroup;
	
	// Number of Members
//	@NotNull(message="Please indicate how many artists are in this collective.")
	@Min(value = 1, message="Must have at least 1 member.")
	@Max(value = 20, message="Cannot have more than 20 members.")
	private Integer memberCount;
	
	@OneToMany(mappedBy="recordingArtist", fetch=FetchType.LAZY)
	private List<Song> songs;

	// Constructors
	// Empty & Mandatory:
	public Artist() {}
		
	// Getters & Setters
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(Boolean isGroup) {
		this.isGroup = isGroup;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	
}
