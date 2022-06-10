package com.sha.serverside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sha.serverside.model.AthUser;
import com.sha.serverside.repository.AthUserRepository;

@Service
@Transactional
public class AthUserServiceImpl implements AthUserService{
	
	@Autowired
	private AthUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public AthUser saveUser(AthUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public AthUser findByAthUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
		
	}
	
	@Override
	public List<AthUser>findAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public AthUser updateUser(AthUser user) {
		return userRepository.save(user);
	}
	
}
