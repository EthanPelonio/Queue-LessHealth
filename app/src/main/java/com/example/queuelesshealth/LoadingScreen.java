package com.example.queuelesshealth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class LoadingScreen extends AppCompatActivity {

    private static final long SPLASH_DELAY = 2500; // 2.5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_5);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(LoadingScreen.this, Login.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}
