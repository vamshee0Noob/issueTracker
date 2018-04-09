package com.example.demo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

@Entity
public class Project implements Serializable,Persistable<Long> {

	Project(){
		
	}
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "projectDesc")
    private String projectDescription;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "project")
    private Set<Issue> issues = new HashSet<>();

    @OneToMany(mappedBy = "project",cascade = CascadeType.MERGE)
    private List<ProjectUser> projectUserList;

    @Version
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }


    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public List<ProjectUser> getProjectUserList() {
        return projectUserList;
    }

    public void setProjectUserList(List<ProjectUser> projectUserList) {
        this.projectUserList = projectUserList;
    }

    public boolean isNew(){
        return null == getId();
    }

    public Long getId(){
        return this.projectId;
    }
}