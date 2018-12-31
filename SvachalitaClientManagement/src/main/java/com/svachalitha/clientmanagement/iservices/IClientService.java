package com.svachalitha.clientmanagement.iservices;

import com.svachalitha.clientmanagement.entity.ClientLogin;

public interface IClientService {

	public ClientLogin saveClient(ClientLogin client);
	public ClientLogin loginClient(String clientName,String passworg);
}
