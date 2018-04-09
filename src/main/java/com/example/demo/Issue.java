package com.example.demo;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;

@Data
@Entity
public class Issue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long issueId;
	
	private String issueName;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonBackReference
	private Project project;

	public Issue() {
		
	}
	public Issue(Long issueId, String issueName, Project project) {
		super();
		this.issueId = issueId;
		this.issueName = issueName;
		this.project = project;
	}
	
	public Issue(String issueName) {
		super();
		this.issueName = issueName;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueName=" + issueName + ", project=" + project + "]";
	}
	
	
	
	
}
