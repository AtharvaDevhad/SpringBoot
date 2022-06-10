package com.sha.serverside.service;

import java.util.List;

import com.sha.serverside.model.AthUser;

public interface AthUserService {

	AthUser saveUser(AthUser user);

	AthUser findByAthUsername(String username);

	List<AthUser> findAllUsers();

	AthUser updateUser(AthUser user);

}
