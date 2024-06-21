package com.lyw.api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import com.lyw.api.ApiApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            ClassLoader classLoader = ApiApplication.class.getClassLoader();
            InputStream serviceAccount = classLoader.getResourceAsStream("firebase_adminsdk.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        }
    }

}