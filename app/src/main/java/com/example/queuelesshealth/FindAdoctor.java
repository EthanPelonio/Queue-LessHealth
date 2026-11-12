package com.example.queuelesshealth;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindAdoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);

        // Initialize views
        View btnBack = findViewById(R.id.btnBack);
        View cardDoctor1 = findViewById(R.id.cardDoctor1);
        View cardDoctor2 = findViewById(R.id.cardDoctor2);
        View cardDoctor3 = findViewById(R.id.cardDoctor3);

        // Back button
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Doctor selections
        if (cardDoctor1 != null) {
            cardDoctor1.setOnClickListener(v ->
                    Toast.makeText(this, "Selected Dr. A. Santos (General Medicine)", Toast.LENGTH_SHORT).show()
            );
        }

        if (cardDoctor2 != null) {
            cardDoctor2.setOnClickListener(v ->
                    Toast.makeText(this, "Selected Dr. R. Cruz (Pediatrics)", Toast.LENGTH_SHORT).show()
            );
        }

        if (cardDoctor3 != null) {
            cardDoctor3.setOnClickListener(v ->
                    Toast.makeText(this, "Selected Dr. L. Reyes (OB-GYN)", Toast.LENGTH_SHORT).show()
            );
        }
    }
}
