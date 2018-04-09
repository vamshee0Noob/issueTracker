package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class ProjectUserService {

    @Autowired
    ProjectUserRepo projectUserRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveOrMerge(ProjectUser projectUser){
        Long id = projectUser.getProject().getProjectId();
        entityManager.merge(projectUser);
    }


}

