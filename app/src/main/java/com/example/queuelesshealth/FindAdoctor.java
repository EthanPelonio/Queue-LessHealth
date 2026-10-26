package com.example.queuelesshealth;

import static android.R.layout.activity_list_item;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FindAdoctor extends AppCompatActivity {

    ImageView btnBack2;
    Button button7;
    LinearLayout layoutDoctor1, layoutDoctor2, layoutDoctor3;

    public FindAdoctor() {
        button7 = findViewById(R.id.button1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_list_item);

        // Initialize views
        btnBack2 = findViewById(R.id.tabs);
        layoutDoctor1 = findViewById(R.id.button1);
        layoutDoctor2 = findViewById(R.id.button2);
        layoutDoctor3 = findViewById(R.id.button3);

        // Back button listener
        if (btnBack2 != null) {
            btnBack2.setOnClickListener(v -> finish());
        }

        // Home button listener
        if (button7 != null) {
            button7.setOnClickListener(v -> {
                Intent intent = new Intent(FindAdoctor.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            });
        }

        // Doctor selection click listeners
        if (layoutDoctor1 != null) {
            layoutDoctor1.setOnClickListener(v -> {
                Toast.makeText(this, "Selected Dr. A. Santos (General Medicine)", Toast.LENGTH_SHORT).show();
            });
        }

        if (layoutDoctor2 != null) {
            layoutDoctor2.setOnClickListener(v -> {
                Toast.makeText(this, "Selected Dr. R. Cruz (Pediatrics)", Toast.LENGTH_SHORT).show();
            });
        }

        if (layoutDoctor3 != null) {
            layoutDoctor3.setOnClickListener(v -> {
                Toast.makeText(this, "Selected Dr. L. Reyes (OB-GYN)", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
