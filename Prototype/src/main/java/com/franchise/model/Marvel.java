package com.franchise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marvel")
public class Marvel {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;
	    
	    @Column(name = "phase")
	    private int phase;

		@Column(name = "movie")
	    private String movie;
	    
	    @Column(name = "depict")
	    private String depict;
	    
	    @Column(name = "posted")
	    private boolean posted;

	    public Marvel() {
			
		}

	    public Marvel(int phase,String movie,String depict,boolean posted){
	    	this.phase=phase;
	        this.movie=movie;
	        this.depict=depict;
	        this.posted=posted;
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

	    public String getMovie() {
	        return movie;
	    }

	    public void setMovie(String movie) {
	        this.movie = movie;
	    }

	    public String getDepict() {
	        return depict;
	    }

	    public void setDepict(String depict) {
	        this.depict = depict;
	    }

	    public boolean isPosted() {
	        return posted;
	    }

	    public void setPosted(boolean posted) {
	        this.posted = posted;
	    }

	    @Override
	    public String toString() {
	        return "Marvel [id="+id+
	        		",phase="+phase+
	        		",movie="+movie+
	        		",depict="+depict+
	        		",posted="+posted+"]";
	    }
}
