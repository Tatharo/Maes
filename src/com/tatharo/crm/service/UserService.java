package com.tatharo.crm.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tatharo.crm.persistence.model.User;
import com.tatharo.crm.persistence.repository.UserRepository;

@Path("/user")
public class UserService {
	@GET
	@Path("/dummy")
	@Produces(MediaType.TEXT_PLAIN)
	public String dummy() {
		new UserRepository().merge(new User("Hashtag"));
		return "Received";
	}
	

}
