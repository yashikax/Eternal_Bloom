package com.example.eternal_bloom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eternal_bloom2.utils.FirebaseUtil;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Button getStartedButton = findViewById(R.id.button);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start LoginActivity when "Get Started" button is clicked
                if(FirebaseUtil.isLoggedIn()) {
                    startActivity(new Intent(WelcomeScreen.this, HomeScreenActivity.class));
                }
                else {
                    startActivity(new Intent(WelcomeScreen.this, LoginPhoneNumberActivity.class));
                }
            }
        });
    }
}