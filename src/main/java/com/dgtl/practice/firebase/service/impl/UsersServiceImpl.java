package com.dgtl.practice.firebase.service.impl;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.dgtl.practice.firebase.model.Users;
import com.dgtl.practice.firebase.service.UsersService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class UsersServiceImpl implements UsersService {

	@Override
	public Users getUsers(String name)throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Users users = null;

        if(document.exists()) {
            users = document.toObject(Users.class);
            return users;
        }else {
            return null;
        }
	}
}
