package com.example.eternal_bloom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HealthTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        TextView textView16 = findViewById(R.id.textView16);
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open HealthTipsActivity
                startActivity(new Intent(HealthTipsActivity.this, MoreHealthTipsActivity.class));
            }
        });

        TextView textView15 = findViewById(R.id.textView15);
        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open ExerciseTipsActivity
                startActivity(new Intent(HealthTipsActivity.this, ExerciseTipsActivity.class));
            }
        });
    }
}