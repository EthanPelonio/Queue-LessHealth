package com.example.queuelesshealth;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.queuelesshealth.R;

public class DoctorDashboard extends AppCompatActivity {

    // 1. UI COMPONENT DECLARATIONS
    private ImageView btnBack;
    private TextView tvGreeting;

    // Filter Tabs
    private Button btnPending, btnAccepted, btnRejected;

    // Patient Card 1
    private CardView cardPatient1;
    private TextView tvPatient1Name, tvPatient1Type, tvPatient1Reason, tvPatient1Time;
    private LinearLayout layoutPatient1Actions;
    private Button btnAccept1, btnReject1;

    // Patient Card 2
    private CardView cardPatient2;
    private TextView tvPatient2Name, tvPatient2Type, tvPatient2Reason, tvPatient2Time;
    private LinearLayout layoutPatient2Actions;
    private Button btnAccept2, btnReject2;

    // Empty State View
    private TextView tvEmptyState;

    // Bottom Navigation
    private Button navHome, navAppointment, navQueue, navProfile;

    // DATA TRACKING & CAPTURE VARIABLES
    private String currentTab = "PENDING";
    private String statusPatient1 = "PENDING";
    private String statusPatient2 = "PENDING";
    private String userEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_2);

        // 1. INITIALIZATION OF VIEWS
        initViews();

        // 2. DATA CAPTURE FROM INTENT
        captureIntentData();

        // 3. SETUP EVENT LISTENERS
        setupEventListeners();

        // 4. INITIAL UI STATE REFRESH
        updateTabSelection(currentTab);
    }

    private void initViews() {
        // Header & Greeting
        btnBack = findViewById(R.id.btnBack);
        tvGreeting = findViewById(R.id.tvGreeting);

        // Tabs
        btnPending = findViewById(R.id.btnPending);
        btnAccepted = findViewById(R.id.btnAccepted);
        btnRejected = findViewById(R.id.btnRejected);

        // Patient Card 1
        cardPatient1 = findViewById(R.id.cardPatient1);
        tvPatient1Name = findViewById(R.id.tvPatient1Name);
        tvPatient1Type = findViewById(R.id.tvPatient1Type);
        tvPatient1Reason = findViewById(R.id.tvPatient1Reason);
        tvPatient1Time = findViewById(R.id.tvPatient1Time);
        layoutPatient1Actions = findViewById(R.id.layoutPatient1Actions);
        btnAccept1 = findViewById(R.id.btnAccept1);
        btnReject1 = findViewById(R.id.btnReject1);

        // Patient Card 2
        cardPatient2 = findViewById(R.id.cardPatient2);
        tvPatient2Name = findViewById(R.id.tvPatient2Name);
        tvPatient2Type = findViewById(R.id.tvPatient2Type);
        tvPatient2Reason = findViewById(R.id.tvPatient2Reason);
        tvPatient2Time = findViewById(R.id.tvPatient2Time);
        layoutPatient2Actions = findViewById(R.id.layoutPatient2Actions);
        btnAccept2 = findViewById(R.id.btnAccept2);
        btnReject2 = findViewById(R.id.btnReject2);

        // Empty State
        tvEmptyState = findViewById(R.id.tvEmptyState);

        // Navigation
        navHome = findViewById(R.id.navHome);
        navAppointment = findViewById(R.id.navAppointment);
        navQueue = findViewById(R.id.navQueue);
        navProfile = findViewById(R.id.navProfile);
    }

    private void captureIntentData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USER_EMAIL")) {
            userEmail = intent.getStringExtra("USER_EMAIL");
            if (userEmail != null && !userEmail.isEmpty()) {
                String greeting = "Hello, Doctor (" + userEmail + ").";
                tvGreeting.setText(greeting);
            }
        }
    }

    private void setupEventListeners() {
        // Back Button Event Listener
        btnBack.setOnClickListener(v -> {
            Toast.makeText(DoctorDashboard.this, "Logging out...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DoctorDashboard.this, Login.class);
            startActivity(intent);
            finish();
        });

        // Tab Event Listeners
        btnPending.setOnClickListener(v -> {
            currentTab = "PENDING";
            updateTabSelection(currentTab);
            Toast.makeText(DoctorDashboard.this, "Viewing Pending Appointments", Toast.LENGTH_SHORT).show();
        });

        btnAccepted.setOnClickListener(v -> {
            currentTab = "ACCEPTED";
            updateTabSelection(currentTab);
            Toast.makeText(DoctorDashboard.this, "Viewing Accepted Appointments", Toast.LENGTH_SHORT).show();
        });

        btnRejected.setOnClickListener(v -> {
            currentTab = "REJECTED";
            updateTabSelection(currentTab);
            Toast.makeText(DoctorDashboard.this, "Viewing Rejected Appointments", Toast.LENGTH_SHORT).show();
        });

        // Patient 1 Action Listeners & Data Capture
        btnAccept1.setOnClickListener(v -> {
            statusPatient1 = "ACCEPTED";
            String name = tvPatient1Name.getText().toString();
            String type = tvPatient1Type.getText().toString();
            String reason = tvPatient1Reason.getText().toString();
            String time = tvPatient1Time.getText().toString();

            Toast.makeText(DoctorDashboard.this, "Accepted " + type + " patient: " + name + " (" + reason + ", " + time + ")", Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        btnReject1.setOnClickListener(v -> {
            statusPatient1 = "REJECTED";
            String name = tvPatient1Name.getText().toString();
            Toast.makeText(DoctorDashboard.this, "Rejected appointment for " + name, Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        // Patient 2 Action Listeners & Data Capture
        btnAccept2.setOnClickListener(v -> {
            statusPatient2 = "ACCEPTED";
            String name = tvPatient2Name.getText().toString();
            String type = tvPatient2Type.getText().toString();
            String reason = tvPatient2Reason.getText().toString();
            String time = tvPatient2Time.getText().toString();

            Toast.makeText(DoctorDashboard.this, "Accepted " + type + " patient: " + name + " (" + reason + ", " + time + ")", Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        btnReject2.setOnClickListener(v -> {
            statusPatient2 = "REJECTED";
            String name = tvPatient2Name.getText().toString();
            Toast.makeText(DoctorDashboard.this, "Rejected appointment for " + name, Toast.LENGTH_SHORT).show();
            updateCardVisibilities();
        });

        // Bottom Navigation Listeners
        navHome.setOnClickListener(v -> {
            setNavActiveButton(navHome);
            Toast.makeText(DoctorDashboard.this, "Home Dashboard", Toast.LENGTH_SHORT).show();
        });

        navAppointment.setOnClickListener(v -> {
            setNavActiveButton(navAppointment);
            Toast.makeText(DoctorDashboard.this, "Appointments Section", Toast.LENGTH_SHORT).show();
        });

        navQueue.setOnClickListener(v -> {
            setNavActiveButton(navQueue);
            Toast.makeText(DoctorDashboard.this, "Queue Overview", Toast.LENGTH_SHORT).show();
        });

        navProfile.setOnClickListener(v -> {
            setNavActiveButton(navProfile);
            Toast.makeText(DoctorDashboard.this, "Doctor Profile", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateTabSelection(String selectedTab) {
        int activeBg = Color.parseColor("#2E7D32");
        int activeText = Color.WHITE;
        int inactiveBg = Color.parseColor("#E3F2FD");
        int inactiveText = Color.parseColor("#0D47A1");

        btnPending.setBackgroundTintList(ColorStateList.valueOf("PENDING".equals(selectedTab) ? activeBg : inactiveBg));
        btnPending.setTextColor("PENDING".equals(selectedTab) ? activeText : inactiveText);

        btnAccepted.setBackgroundTintList(ColorStateList.valueOf("ACCEPTED".equals(selectedTab) ? activeBg : inactiveBg));
        btnAccepted.setTextColor("ACCEPTED".equals(selectedTab) ? activeText : inactiveText);

        btnRejected.setBackgroundTintList(ColorStateList.valueOf("REJECTED".equals(selectedTab) ? activeBg : inactiveBg));
        btnRejected.setTextColor("REJECTED".equals(selectedTab) ? activeText : inactiveText);

        updateCardVisibilities();
    }

    private void updateCardVisibilities() {
        boolean isCard1Visible = statusPatient1.equalsIgnoreCase(currentTab);
        boolean isCard2Visible = statusPatient2.equalsIgnoreCase(currentTab);

        cardPatient1.setVisibility(isCard1Visible ? View.VISIBLE : View.GONE);
        cardPatient2.setVisibility(isCard2Visible ? View.VISIBLE : View.GONE);

        // Hide action buttons if the card is already Accepted or Rejected
        if (!"PENDING".equals(statusPatient1)) {
            layoutPatient1Actions.setVisibility(View.GONE);
        } else {
            layoutPatient1Actions.setVisibility(View.VISIBLE);
        }

        if (!"PENDING".equals(statusPatient2)) {
            layoutPatient2Actions.setVisibility(View.GONE);
        } else {
            layoutPatient2Actions.setVisibility(View.VISIBLE);
        }

        // Show empty state if no cards match the active tab filter
        if (!isCard1Visible && !isCard2Visible) {
            String emptyMsg = "No " + currentTab.toLowerCase() + " appointments.";
            tvEmptyState.setText(emptyMsg);
            tvEmptyState.setVisibility(View.VISIBLE);
        } else {
            tvEmptyState.setVisibility(View.GONE);
        }
    }

    private void setNavActiveButton(Button activeButton) {
        int activeBg = Color.parseColor("#2E7D32");
        int activeText = Color.WHITE;
        int inactiveBg = Color.parseColor("#E3F2FD");
        int inactiveText = Color.parseColor("#0D47A1");

        Button[] navButtons = {navHome, navAppointment, navQueue, navProfile};
        for (Button btn : navButtons) {
            if (btn == activeButton) {
                btn.setBackgroundTintList(ColorStateList.valueOf(activeBg));
                btn.setTextColor(activeText);
            } else {
                btn.setBackgroundTintList(ColorStateList.valueOf(inactiveBg));
                btn.setTextColor(inactiveText);
            }
        }
    }
}
