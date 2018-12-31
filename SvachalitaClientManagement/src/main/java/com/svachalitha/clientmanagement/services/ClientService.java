package com.svachalitha.clientmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.svachalitha.clientmanagement.entity.ClientLogin;
import com.svachalitha.clientmanagement.iservices.IClientService;
import com.svachalitha.clientmanagement.repo.ClientLoginRepo;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private ClientLoginRepo clientLoginRepo;

	@Transactional
	@Override
	public ClientLogin saveClient(ClientLogin client) {
		return clientLoginRepo.save(client);
	}
	
	@Transactional(readOnly=true)
	@Override
	public ClientLogin loginClient(String username,String password) {
		return clientLoginRepo.getByNameAndPassword(username, password);
	}


}
