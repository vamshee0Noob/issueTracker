package com.example.demo;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {
	
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	IssueRepo issueRepo;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/projects")
	public ResponseEntity<List<Project>> getAllprojects() {
		List<Project> projects = (List<Project>)projectRepo.findAll();
		
		for(Project project:projects) {
			System.out.println("------------" + project + "------------------");
			Set<Issue> issues = project.getIssues();
			System.out.println("------------" + issues + "------------------");
		}
		ResponseEntity<List<Project>> response = new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
		
		return response;
	}
	
	@RequestMapping(value = "/issues")
	public ResponseEntity<List<Issue>> getAllIssues() {
		List<Issue> issues = (List<Issue>) issueRepo.findAll();
		
		for(Issue issue:issues) {
			System.out.println("------------" + issue + "------------------");
		}
		ResponseEntity<List<Issue>> response = new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
		
		return response;
	}
	
}
