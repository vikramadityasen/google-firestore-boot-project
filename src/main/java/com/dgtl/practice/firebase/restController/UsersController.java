package com.dgtl.practice.firebase.restController;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgtl.practice.firebase.service.UsersService;
import com.google.cloud.firestore.QueryDocumentSnapshot;

@RequestMapping("/api")
@RestController
public class UsersController {

	@Autowired UsersService usersService;
	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QueryDocumentSnapshot> getUsers() throws InterruptedException, ExecutionException{
		return usersService.getUsers();
	} 
}
