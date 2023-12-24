package com.nikhil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.Entity.City;

@Repository
public interface cityRepo extends JpaRepository<City, Integer> {

}
