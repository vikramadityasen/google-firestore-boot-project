package com.dgtl.practice.firebase.service.impl;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitServiceImpl{

	@PostConstruct
	public void initialize(){
		try {
			FileInputStream serviceAccount = new FileInputStream("./practice-firebase-project.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://practice-firebase-projec-dac24.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
