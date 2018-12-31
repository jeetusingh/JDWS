package com.svachalitha.clientmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svachalitha.clientmanagement.entity.ClientLogin;

@Repository
public interface ClientLoginRepo extends JpaRepository<ClientLogin, Long>{
	
	public ClientLogin getByNameAndPassword(String name,String password);

}
