package com.gtl.simpleProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtl.simpleProject.entities.SimpleUser;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Integer>{

}
