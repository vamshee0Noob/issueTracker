package com.example.demo;



import java.io.Serializable;


public class ProjectUserID implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long project;
    private Long user;

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
