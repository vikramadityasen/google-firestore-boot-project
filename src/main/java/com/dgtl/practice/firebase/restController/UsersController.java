package com.dgtl.practice.firebase.restController;


import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgtl.practice.firebase.model.Users;
import com.dgtl.practice.firebase.service.UsersService;

@RequestMapping("/api")
@RestController
public class UsersController {

	@Autowired UsersService usersService;
	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Users getUsers() throws InterruptedException, ExecutionException{
		return usersService.getUsers();
	} 
	
	@GetMapping(value = "/users/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Users getUsers(@PathVariable String name) throws InterruptedException, ExecutionException{
		return usersService.getUsers(name);
	} 
	
	@PostMapping(value = "/createUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String saveUsersDetails(@RequestBody Users users) throws InterruptedException, ExecutionException {
        return usersService.saveUsersDetails(users);
    }
	
	@PutMapping(value = "/updateUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateUsersDetails(@RequestBody Users users) throws InterruptedException, ExecutionException {
        return usersService.updateUsersDetails(users);
    }
	
	@DeleteMapping(value = "/deleteUser/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteUser(@PathVariable String name) throws InterruptedException, ExecutionException{
        return usersService.deleteUser(name);
    }
}
