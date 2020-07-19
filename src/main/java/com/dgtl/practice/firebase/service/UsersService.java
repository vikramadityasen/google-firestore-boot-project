package com.dgtl.practice.firebase.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.QueryDocumentSnapshot;

public interface UsersService {

	List<QueryDocumentSnapshot> getUsers() throws InterruptedException, ExecutionException;

}
