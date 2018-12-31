package com.svachalitha.clientmanagement.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.svachalitha.clientmanagement.entity.ClientLogin;
import com.svachalitha.clientmanagement.exceptions.InvalidClientInfoException;
import com.svachalitha.clientmanagement.iservices.IClientService;

import io.swagger.annotations.Api;

@Api(value = "client services", description = "Client Registration And Authentication Process")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService iclientService;

	@RequestMapping(path = "/client.svachalitha", method = { RequestMethod.GET })
	public String get() {
		return "client";
	}

	@RequestMapping(path = "/client.svachalitha", method = { RequestMethod.POST })
	public ClientLogin saveClient(@Valid @RequestBody ClientLogin client, BindingResult result)
			throws InvalidClientInfoException {
		if (result.hasErrors()) {
			throw new InvalidClientInfoException(HttpStatus.NOT_ACCEPTABLE, "Client Data Is Invalid", result);
		}
		return iclientService.saveClient(client);
	}
	
	@RequestMapping(path = "/loginClient.svachalitha",method= {RequestMethod.GET})
	public String loginClient(@RequestParam("clientname") String clientname,@RequestParam("password") String password)
			throws InvalidClientInfoException {
		ClientLogin clientLogin=iclientService.loginClient(clientname, password);
		if(clientLogin==null) {
			return "Authentication Fail";
		}
		return "Login Success";
	}
}
