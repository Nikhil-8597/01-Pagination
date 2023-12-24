package com.nikhil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.Entity.Employee;

@Repository
public interface EmpREpo extends JpaRepository<Employee, Integer>{

}
