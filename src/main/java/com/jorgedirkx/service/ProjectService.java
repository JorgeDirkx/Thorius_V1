package com.jorgedirkx.service;


import com.jorgedirkx.model.Project;
import com.jorgedirkx.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    //not recommended ?
    @Autowired
    private ProjectRepository repo;

    public List<Project> listAll(){
        return repo.findAll();
    }
    public void save(Project project){
        repo.save(project);
    }
    public Project get(long id){
        return repo.findById(id).get();
    }
    public void delete(long id){
        repo.deleteById(id);
    }

}
