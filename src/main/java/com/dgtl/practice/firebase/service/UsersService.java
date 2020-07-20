package com.dgtl.practice.firebase.service;

import java.util.concurrent.ExecutionException;

import com.dgtl.practice.firebase.model.Users;

public interface UsersService {

	Users getUsers() throws InterruptedException, ExecutionException;

	Users getUsers(String name) throws InterruptedException, ExecutionException;

	String saveUsersDetails(Users users) throws InterruptedException, ExecutionException;

	String updateUsersDetails(Users users) throws InterruptedException, ExecutionException;

	String deleteUser(String name) throws InterruptedException, ExecutionException;

}
