package com.dgtl.practice.firebase.service;

import java.util.concurrent.ExecutionException;

import com.dgtl.practice.firebase.model.Users;

public interface UsersService {

	Users getUsers(String name) throws InterruptedException, ExecutionException;

}
