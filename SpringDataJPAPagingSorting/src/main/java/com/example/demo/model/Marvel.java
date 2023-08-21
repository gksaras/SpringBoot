package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="marvels")
public class Marvel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "phase")
	private int phase;
	
	@Column(name = "franchise")
	private String franchise;
	
	@Column(name = "published")
	private boolean published;
	
	public Marvel() {

	}
	
	public Marvel(int phase,String franchise,boolean published) {
		this.phase = phase;
		this.franchise = franchise;
		this.published = published;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public String getFranchise() {
		return franchise;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	@Override
	public String toString() {
		return "Marvel[id="+id
				+",phase="+phase
				+",franchise="+franchise
				+",published="+published+"]";
	}
}
