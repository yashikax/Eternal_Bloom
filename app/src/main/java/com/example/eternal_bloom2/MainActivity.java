package com.example.eternal_bloom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.eternal_bloom2.model.UserModel;
import com.example.eternal_bloom2.utils.AndroidUtil;
import com.example.eternal_bloom2.utils.FirebaseUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String userId = getIntent().getExtras().getString("userId");
//        if (getIntent().getExtras() != null && userId != null) {
//            //from notification
//            //String userId = getIntent().getExtras().getString("userId");
//            FirebaseUtil.allUserCollectionReference().document(userId).get()
//                    .addOnCompleteListener(task -> {
//                        if (task.isSuccessful()) {
//                            UserModel model = task.getResult().toObject(UserModel.class);
//
//                            Intent mainIntent = new Intent(this, DoctorChatActivity.class);
//                            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                            startActivity(mainIntent);
//
//                            Intent intent = new Intent(this, ChatActivity.class);
//                            AndroidUtil.passUserModelAsIntent(intent, model);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
//                            finish();
//                        }
//                    });
//
//
//        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, WelcomeScreen.class));
                    finish();
                }
            }, 4000);
        //}
    }
}