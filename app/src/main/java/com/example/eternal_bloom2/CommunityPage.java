package com.example.eternal_bloom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CommunityPage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_page);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ImageView imageView23 = findViewById(R.id.imageView23);
        ImageView imageView18 = findViewById(R.id.imageView18);
        ImageView imageView25= findViewById(R.id.imageView25);
        TextView textView30 = findViewById(R.id.textView30);
        ImageView imageView27= findViewById(R.id.imageView27);
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(CommunityPage.this, YogaCommunity.class));
            }
        });
        imageView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(CommunityPage.this, PeaceCommunity.class));
            }
        });
        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(CommunityPage.this, MealCommunity.class));
            }
        });
        textView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(CommunityPage.this, MealCommunity.class));
            }
        });
        imageView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(CommunityPage.this, WellnessCommunity.class));
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.menu_community){

                }
                if(item.getItemId()==R.id.menu_home){
                    startActivity(new Intent(CommunityPage.this, HomeScreenActivity.class));
                }

                return true;
            }
        });
    }
}