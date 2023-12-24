package com.nikhil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.Entity.Student;

@Repository
public interface stuRepo extends JpaRepository<Student, Integer>{

}
