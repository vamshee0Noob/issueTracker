package com.example.demo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "project_user")
@IdClass(ProjectUserID.class)
public class ProjectUser implements Serializable{

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    @JsonBackReference
    private SiteUser user;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId",referencedColumnName = "projectId")
    @JsonBackReference
    private Project project;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public ProjectUser(SiteUser user, Project project, Role role) {
        this.user = user;
        this.project = project;
        this.role = role;
    }

    @Version
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public SiteUser getUser() {
        return user;
    }

    public void setUser(SiteUser user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public ProjectUser(){

    }
}

