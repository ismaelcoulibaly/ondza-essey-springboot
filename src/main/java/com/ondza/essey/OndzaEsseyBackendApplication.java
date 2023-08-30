package com.ondza.essey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
@SpringBootApplication
public class OndzaEsseyBackendApplication {

    public static void main(String[] args) throws IOException {


        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/ondza-essey-firebase-adminsdk-y4r21-1d6c0aea85.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);


        SpringApplication.run(OndzaEsseyBackendApplication.class, args);
    }



}
