package com.example.queuelesshealth;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class DoctorDashboard extends AppCompatActivity {

    private View btnBack;
    private TextView tvGreeting;

    // Filter Tabs
    private MaterialCardView tabPending, tabAccepted, tabRejected;

    // Patient Cards
    private MaterialCardView cardPatient1, cardPatient2;
    private TextView tvPatientName1, tvReason1, tvDateTime1;
    private TextView tvPatientName2, tvReason2, tvDateTime2;
    private Button btnAccept1, btnReject1;
    private Button btnAccept2, btnReject2;

    // Bottom Navigation
    private View navHome, navAppointments, navQueue, navProfile;

    private String currentTab = "PENDING";
    private String statusPatient1 = "PENDING";
    private String statusPatient2 = "PENDING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_2);

        initViews();
        setupEventListeners();
        updateTabSelection("PENDING");
    }

    private void initViews() {
        btnBack = findViewById(R.id.btnBack);
        tvGreeting = findViewById(R.id.tvGreeting);

        tabPending = findViewById(R.id.tabPending);
        tabAccepted = findViewById(R.id.tabAccepted);
        tabRejected = findViewById(R.id.tabRejected);

        cardPatient1 = findViewById(R.id.cardPatient1);
        tvPatientName1 = findViewById(R.id.tvPatientName1);
        tvReason1 = findViewById(R.id.tvReason1);
        tvDateTime1 = findViewById(R.id.tvDateTime1);
        btnAccept1 = findViewById(R.id.btnAccept1);
        btnReject1 = findViewById(R.id.btnReject1);

        cardPatient2 = findViewById(R.id.cardPatient2);
        tvPatientName2 = findViewById(R.id.tvPatientName2);
        tvReason2 = findViewById(R.id.tvReason2);
        tvDateTime2 = findViewById(R.id.tvDateTime2);
        btnAccept2 = findViewById(R.id.btnAccept2);
        btnReject2 = findViewById(R.id.btnReject2);

        navHome = findViewById(R.id.navHome);
        navAppointments = findViewById(R.id.navAppointments);
        navQueue = findViewById(R.id.navQueue);
        navProfile = findViewById(R.id.navProfile);

        String email = getIntent().getStringExtra("USER_EMAIL");
        if (email != null && !email.isEmpty()) {
            tvGreeting.setText("Hello, Dr. " + email);
        }
    }

    private void setupEventListeners() {
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        tabPending.setOnClickListener(v -> {
            currentTab = "PENDING";
            updateTabSelection("PENDING");
            Toast.makeText(this, "Viewing Pending Appointments", Toast.LENGTH_SHORT).show();
        });

        tabAccepted.setOnClickListener(v -> {
            currentTab = "ACCEPTED";
            updateTabSelection("ACCEPTED");
            Toast.makeText(this, "Viewing Accepted Appointments", Toast.LENGTH_SHORT).show();
        });

        tabRejected.setOnClickListener(v -> {
            currentTab = "REJECTED";
            updateTabSelection("REJECTED");
            Toast.makeText(this, "Viewing Rejected Appointments", Toast.LENGTH_SHORT).show();
        });

        btnAccept1.setOnClickListener(v -> {
            statusPatient1 = "ACCEPTED";
            Toast.makeText(this, "Accepted appointment for Patient 1", Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        btnReject1.setOnClickListener(v -> {
            statusPatient1 = "REJECTED";
            Toast.makeText(this, "Rejected appointment for Patient 1", Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        btnAccept2.setOnClickListener(v -> {
            statusPatient2 = "ACCEPTED";
            Toast.makeText(this, "Accepted appointment for Patient 2", Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        btnReject2.setOnClickListener(v -> {
            statusPatient2 = "REJECTED";
            Toast.makeText(this, "Rejected appointment for Patient 2", Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        if (navHome != null) navHome.setOnClickListener(v -> Toast.makeText(this, "Home Dashboard", Toast.LENGTH_SHORT).show());
        if (navAppointments != null) navAppointments.setOnClickListener(v -> Toast.makeText(this, "Appointments", Toast.LENGTH_SHORT).show());
        if (navQueue != null) navQueue.setOnClickListener(v -> Toast.makeText(this, "Queue Overview", Toast.LENGTH_SHORT).show());
        if (navProfile != null) navProfile.setOnClickListener(v -> Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show());
    }

    private void updateTabSelection(String selectedTab) {
        int activeColor = Color.parseColor("#0E9488");
        int inactiveColor = Color.parseColor("#00000000");

        tabPending.setCardBackgroundColor("PENDING".equals(selectedTab) ? activeColor : inactiveColor);
        tabAccepted.setCardBackgroundColor("ACCEPTED".equals(selectedTab) ? activeColor : inactiveColor);
        tabRejected.setCardBackgroundColor("REJECTED".equals(selectedTab) ? activeColor : inactiveColor);

        updateCardVisibilities();
    }

    private void updateCardVisibilities() {
        boolean show1 = statusPatient1.equalsIgnoreCase(currentTab);
        boolean show2 = statusPatient2.equalsIgnoreCase(currentTab);

        cardPatient1.setVisibility(show1 ? View.VISIBLE : View.GONE);
        cardPatient2.setVisibility(show2 ? View.VISIBLE : View.GONE);
    }
}
