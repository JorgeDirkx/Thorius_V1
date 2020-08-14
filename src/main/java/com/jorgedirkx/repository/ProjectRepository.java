package com.jorgedirkx.repository;

import com.jorgedirkx.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
