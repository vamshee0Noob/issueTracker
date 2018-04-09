package com.example.demo;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Id @GeneratedValue Long commentId;
	private String comment;
	

	
	public Comment(){
		}

	public Comment(Long commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}
	
	
}
