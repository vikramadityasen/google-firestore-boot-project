package com.dgtl.practice.firebase.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.dgtl.practice.firebase.model.Users;
import com.dgtl.practice.firebase.service.UsersService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class UsersServiceImpl implements UsersService {

	@Override
	public List<QueryDocumentSnapshot> getUsers() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			  System.out.println(document.getId() + " => " + document.toObject(Users.class));
			}
		return documents;
	}
}
