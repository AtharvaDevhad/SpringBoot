package com.sha.serverside.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.serverside.model.AthUser;

public interface AthUserRepository extends JpaRepository<AthUser,Long> {
	
	AthUser findByUsername(String username);

}
