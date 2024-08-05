package com.example.eternal_bloom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eternal_bloom2.model.ChatroomModel;
import com.example.eternal_bloom2.model.UserModel;
import com.example.eternal_bloom2.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeScreenActivity extends AppCompatActivity {
    ProfileFragment profileFragment;
    UserModel userModel;
    TextView textView19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        fetchUserDetails();

        ImageView imageView16 = findViewById(R.id.imageView16);
        TextView textView9 = findViewById(R.id.textView9);
        ImageView imageView12 = findViewById(R.id.imageView12);
        TextView textView5 = findViewById(R.id.textView5);
        ImageView imageView15 = findViewById(R.id.imageView15);
        TextView textView8 = findViewById(R.id.textView8);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView11 = findViewById(R.id.imageView11);
        TextView textView4 = findViewById(R.id.textView4);
        ImageView imageView10 = findViewById(R.id.imageView10);
        TextView textView3 = findViewById(R.id.textView3);
        ImageView imageView13 = findViewById(R.id.imageView13);
        TextView textView6 = findViewById(R.id.textView6);


        //userModel =

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu =new PopupMenu(HomeScreenActivity.this, imageView5);
                menu.getMenuInflater().inflate(R.menu.options_menu, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id=item.getItemId();
                        if(id==R.id.menu_profile){
                            Intent intent = new Intent(HomeScreenActivity.this, DoctorChatActivity.class);
                            //getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,profileFragment).commit();
                        }
                        else if(id==R.id.menu_logout){
                            Toast.makeText(HomeScreenActivity.this,"Logging Out",Toast.LENGTH_SHORT).show();
                            FirebaseMessaging.getInstance().deleteToken().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        FirebaseUtil.logout();
                                        Intent intent = new Intent(HomeScreenActivity.this, WelcomeScreen.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }
                                }
                            });
                        }
                        else if(id==R.id.menu_alert){
                            //Toast.makeText(HomeScreenActivity.this,"Alerting Caretaker",Toast.LENGTH_SHORT).show();
                            String caretakerFCMToken = "d2FaY2GfRZKEDlnKdlf8HC:APA91bG1bjIi-FMO3IX-yQE1wlhTOmrI9QRSCWJgMLrt7j1CuBwen52-fom5N8wUX42qGcrhq8UYsbHtqre4xnYP-egXk4y5d-sEl8F6k1S8g7Rqf6rEQbV9P7ohOb6ZQVPI3ndzjsXj"    ;
                            //userModel = task.getResult().toObject(UserModel.class);
                            //String name = userModel.getUsername();
                            //String sending = name + " Requires your assistance!";
                            sendNotificationToCaretaker(caretakerFCMToken);

                        }
                        return true;
                    }
                });
                menu.show();
            }
        });

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, ECommerce.class));
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, ECommerce.class));
            }
        });
        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, QuizActivity.class));
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, QuizActivity.class));
            }
        });
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, CalendarMain.class));
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, CalendarMain.class));
            }
        });
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, HealthTipsActivity.class));
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, HealthTipsActivity.class));
            }
        });

        imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, DoctorChatActivity.class));
            }
        });

        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, DoctorChatActivity.class));
            }
        });
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, CommunityPage.class));
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DoctorChatActivity
                startActivity(new Intent(HomeScreenActivity.this, CommunityPage.class));
            }
        });
    }
    private void fetchUserDetails() {
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                TextView textView19 = findViewById(R.id.textView19);
                userModel = task.getResult().toObject(UserModel.class);
                if (userModel != null) {
                    textView19.setText(userModel.getUsername());
                    // User details fetched successfully
                    // You can access userModel.getUsername() anywhere in this class now
                } else {
                    // Handle case where UserModel is null
                    Toast.makeText(HomeScreenActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Handle task failure
                Toast.makeText(HomeScreenActivity.this, "Failed to fetch user details", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void sendNotificationToCaretaker(String recipientFCMToken){
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(HomeScreenActivity.this,"Alerted",Toast.LENGTH_SHORT).show();
                UserModel currentUser = task.getResult().toObject(UserModel.class);
                String name = currentUser.getUsername();
                String sending = name + " Requires your assistance!";
                try {
                    JSONObject jsonObject = new JSONObject();

                    JSONObject notificationObj = new JSONObject();
                    notificationObj.put("title", "Alert Message");
                    notificationObj.put("body", sending);

                    JSONObject dataObj = new JSONObject();
                    dataObj.put("userId", currentUser.getUserId());

                    jsonObject.put("notification", notificationObj);
                    jsonObject.put("data", dataObj);
                    jsonObject.put("to", recipientFCMToken);

                    callApi1(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    void callApi1(JSONObject jsonObject) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String url = "https://fcm.googleapis.com/fcm/send";
        RequestBody body = RequestBody.create(jsonObject.toString(), JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Authorization", "Bearer AAAA3F8CnuU:APA91bFPqzoR1CY482i3A_hHThD2s6JBdY8qo7648HhJrH95vEqPpqrWkhbI-HnSxMZ3jYxsqC2YOfSDrtUkHqZt43B-BEOU0U3pkSSAiV8XrfmIkqgB7gtoGfv_lGiDRwr1BDTZ0McV")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            }
        });
    }
}