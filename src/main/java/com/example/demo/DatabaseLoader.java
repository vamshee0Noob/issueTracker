package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner{

    ProjectRepo projectRepo;

    IssueRepo issueRepo;

    CommentRepo commentRepo;

    UserRepo userRepo;

    ProjectUserService projectUserService;

    @Autowired
    DatabaseLoader(ProjectRepo projectRepo, IssueRepo issueRepo, CommentRepo commentRepo, UserRepo userRepo, ProjectUserService projectUserService){
        this.projectRepo = projectRepo;
        this.issueRepo = issueRepo;
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.projectUserService = projectUserService;
    }

    @Override
    public void run(String... strings) throws Exception {

        SiteUser user1 = new SiteUser("Second User","user2@gmail.com","password",true);
        SiteUser user2 = new SiteUser("Third User","user3@gmail.com","password",true);
        this.userRepo.save(user1);
        this.userRepo.save(user2);

        Project project5 = new Project();
        project5.setProjectName("Fifth project");
        project5.setProjectDescription("Fifth desc");
        this.projectRepo.save(project5);

        Project project6 = new Project();
        project6.setProjectName("Sixth project");
        project6.setProjectDescription("Sixth desc");
        this.projectRepo.save(project6);

        ProjectUser projectUser1 = new ProjectUser(user1,project5,Role.CONTRIBUTOR);
        ProjectUser projectUser2 = new ProjectUser(user1,project6,Role.ADMIN);
        this.projectUserService.saveOrMerge(projectUser1);
        this.projectUserService.saveOrMerge(projectUser2);


        List<ProjectUser> projectUsers2 = new ArrayList<>();
        ProjectUser projectUser3 = new ProjectUser(user2,project5,Role.CONTRIBUTOR);
        projectUsers2.add(projectUser1);
        projectUsers2.add(projectUser3);
        this.projectUserService.saveOrMerge(projectUser3);
         /*
        Issue issue = new Issue();
        issue.setProject(project);
        issue.setIssueName("First issue");
        issue.setIssueDescription("Description");
        issue.setStatus("Open");
        this.issueDao.save(issue);

        issue = new Issue();
        issue.setProject(project);
        issue.setIssueName("Second issue");
        issue.setIssueDescription("Description");
        issue.setStatus("Open");
        this.issueDao.save(issue);

        issue = new Issue();
        issue.setProject(project);
        issue.setIssueName("Fourth issue");
        issue.setIssueDescription("Description");
        issue.setStatus("Open");
        this.issueDao.save(issue);

        Comment comment = new Comment();
        comment.setIssue(issue);
        comment.setComment("First Comment");
        this.commentDao.save(comment);

        comment = new Comment();
        comment.setIssue(issue);
        comment.setComment("Second Comment");
        this.commentDao.save(comment);

        comment = new Comment();
        comment.setIssue(issue);
        comment.setComment("Third Comment");
        this.commentDao.save(comment);

        comment = new Comment();
        comment.setIssue(issue);
        comment.setComment("Fourth Comment");
        this.commentDao.save(comment);*/
    }


}
