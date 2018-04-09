package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SiteUser implements Serializable{

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ProjectUser> projectUserList;

    @Column(name = "enabled")
    private boolean isEnabled;

    public SiteUser(){

    }

    @Version
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public SiteUser(String userName, String emailId, String password, boolean isEnabled) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    public List<ProjectUser> getProjectUserList() {
        return projectUserList;
    }

    public void setProjectUserList(List<ProjectUser> projectUserList) {
        this.projectUserList = projectUserList;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<ProjectUser> getProjectusers() {
        return projectUserList;
    }

    public void setProjectusers(List<ProjectUser> projectUserList) {
        this.projectUserList = projectUserList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
